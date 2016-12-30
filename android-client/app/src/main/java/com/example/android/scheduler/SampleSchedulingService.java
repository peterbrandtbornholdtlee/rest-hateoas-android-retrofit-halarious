package com.example.android.scheduler;

import android.app.IntentService;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;
import android.telephony.SmsManager;
import android.util.Log;

import com.example.android.scheduler.rest.Message;
import com.example.android.scheduler.rest.MessagesServiceImpl;

import java.util.List;

/**
 * This {@code IntentService} does the app's actual work.
 * {@code SampleAlarmReceiver} (a {@code WakefulBroadcastReceiver}) holds a
 * partial wake lock for this service while the service does its work. When the
 * service is finished, it calls {@code completeWakefulIntent()} to release the
 * wake lock.
 */
public class SampleSchedulingService extends IntentService {

    public SampleSchedulingService() {
        super("SchedulingService");
    }

    public static final String TAG = SampleSchedulingService.class.getName();
    // An ID used to post the notification.
    public static final int NOTIFICATION_ID = 1;

    MessagesServiceImpl messagesService = new MessagesServiceImpl();

    @Override
    protected void onHandleIntent(Intent intent) {

        List<Message> messages = downloadMessages();

        sendNotification("Messages downloaded: " + messages.size());

        // Release the wake lock provided by the BroadcastReceiver.
        SampleAlarmReceiver.completeWakefulIntent(intent);

    }

    private List<Message> downloadMessages() {
        List<Message> messages = messagesService.getMessages();
        if(messages!=null) {
            for ( Message m : messages ) {
                Log.d(TAG, "Telefone: " + m.getTelefone());
                Log.d(TAG, "Body: " + m.getBody());

                // Get the default instance of SmsManager
                SmsManager smsManager = SmsManager.getDefault();
                // Send a text based SMS
                smsManager.sendTextMessage(m.getTelefone(), null, m.getBody(), null, null);
            }
        } else {
            Log.d(TAG, "No messages found!");
        }
        return messages;
    }

    // Post a notification indicating whether a doodle was found.
    private void sendNotification(String msg) {
        NotificationManager mNotificationManager = (NotificationManager)
                this.getSystemService(Context.NOTIFICATION_SERVICE);
    
        PendingIntent contentIntent = PendingIntent.getActivity(this, 0,
            new Intent(this, MainActivity.class), 0);

        NotificationCompat.Builder mBuilder =
                new NotificationCompat.Builder(this)
        .setSmallIcon(R.drawable.ic_launcher)
        .setContentTitle(getString(R.string.doodle_alert))
        .setStyle(new NotificationCompat.BigTextStyle()
        .bigText(msg))
        .setContentText(msg);

        mBuilder.setContentIntent(contentIntent);
        mNotificationManager.notify(NOTIFICATION_ID, mBuilder.build());
    }

}
