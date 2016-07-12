package com.epicodus.chatforum.models;


import java.util.ArrayList;
import java.util.List;

public class Category {
    String categoryName;
    List<Message> messages = new ArrayList<>();

    public Category () {};

    public Category(String categoryName, ArrayList<Message> messages) {
        this.categoryName = categoryName;
        this.messages = messages;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public List<Message> getMessages() {
        return messages;
    }
}



