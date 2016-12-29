package com.example.android.scheduler.rest;

import com.example.android.scheduler.rest.hal.MessageList;

import retrofit2.Call;
import retrofit2.http.GET;

public interface MessagesAPI {

    @GET("messages")
    Call<MessageList> listMessages();

}