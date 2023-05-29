package com.vkchtt.chtapp;

public class ChatMess {
    public String userPhoto;
    public String userName;
    public String userID;
    public String message;

    public ChatMess(String userPhoto, String userName, String userID, String message) {
        this.userPhoto = userPhoto;
        this.userName = userName;
        this.userID = userID;
        this.message = message;
    }
}