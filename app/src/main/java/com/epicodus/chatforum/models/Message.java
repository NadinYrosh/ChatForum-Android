package com.epicodus.chatforum.models;


public class Message {


    String message;
    public Message () {};

    public Message(String message) {
        this.message = message;
    }

    public String getMessage() { return message;}
}
