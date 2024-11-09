package org.example.zeroproject.models;

import java.util.Date;

public class Message {
    private String text;
    private Date date;
    public Message(String text){
        this.text = text;
        this.date = new Date();
    }

    public String getText() {
        return text;
    }

    public Date getDate() {
        return date;
    }
}
