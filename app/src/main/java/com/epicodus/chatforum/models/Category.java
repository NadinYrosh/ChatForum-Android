package com.epicodus.chatforum.models;


public class Category {
    String categoryName;

    public Category () {};

    public Category(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getCategoryName() {
        return categoryName;
    }
}

