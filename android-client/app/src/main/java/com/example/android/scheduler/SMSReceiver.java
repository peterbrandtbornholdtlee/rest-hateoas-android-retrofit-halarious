package com.example.android.scheduler;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.SmsMessage;
import android.util.Log;
import android.widget.Toast;

public class SMSReceiver extends BroadcastReceiver
{
    public static final String TAG = SMSReceiver.class.getName();

    @Override
    public void onReceive(Context context, Intent intent)
    {

        Bundle bundle = intent.getExtras();
        SmsMessage[] recievedMsgs = null;
        String str = "";
        if (bundle != null)
        {

            Object[] pdus = (Object[]) bundle.get("pdus");
            recievedMsgs = new SmsMessage[pdus.length];
            for (int i=0; i<pdus.length; i++) {
                recievedMsgs[i] = SmsMessage.createFromPdu((byte[])pdus[i]);
                str += "SMS from " + recievedMsgs[i].getOriginatingAddress()+ " :" + recievedMsgs[i].getMessageBody().toString();

                Log.d(TAG, "getOriginatingAddress: " + recievedMsgs[i].getOriginatingAddress());
                Log.d(TAG, "getMessageBody: " + recievedMsgs[i].getMessageBody());
            }

            Toast.makeText(context, str, Toast.LENGTH_SHORT).show();
        }
    }
}