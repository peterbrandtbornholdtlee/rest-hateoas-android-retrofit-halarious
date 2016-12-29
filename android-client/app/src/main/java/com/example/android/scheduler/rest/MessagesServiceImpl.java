package com.example.android.scheduler.rest;

import android.util.Log;

import com.example.android.scheduler.rest.hal.HALConverterFactory;
import com.example.android.scheduler.rest.hal.MessageList;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

/**
 * Created by rodrigo.ijk on 29/12/2016.
 */

    public class MessagesServiceImpl {

    private static final String TAG = MessagesServiceImpl.class.getName();

    public List<Message> getMessages() {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://192.168.10.108:8080")
                .addConverterFactory(HALConverterFactory.create(MessageList.class))
                .build();

        MessagesAPI service = retrofit.create(MessagesAPI.class);

        try {
            return service.listMessages().execute().body().getMessages();
        } catch (Exception e) {
            Log.e(TAG, e.getMessage(), e);
        }
        return null;
    }
}
