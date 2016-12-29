package com.example.android.scheduler.rest.hal;

import com.example.android.scheduler.rest.Message;

import java.util.ArrayList;
import java.util.List;

import ch.halarious.core.HalResource;

/**
 * Created by rodrigo.ijk on 29/12/2016.
 */

public class MessageList implements HalResource {

    private List<Message> messages = new ArrayList<Message>();

    public List<Message> getMessages() {
        return messages;
    }

    public void setMessages(List<Message> messages) {
        this.messages = messages;
    }
}
