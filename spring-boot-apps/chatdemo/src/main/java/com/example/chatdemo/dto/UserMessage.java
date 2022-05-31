package com.example.chatdemo.dto;

public class UserMessage {


    private String message;
    private long timestamp;
    private boolean isSent;


    public UserMessage(String message) {
        this.message = message;
        this.timestamp = System.currentTimeMillis();
        this.isSent = true;
    }

    public UserMessage(String message, boolean isSent) {
        this.message = message;
        this.timestamp = System.currentTimeMillis();
        this.isSent = isSent;
    }

    public UserMessage() {
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    public Boolean getSent() {
        return isSent;
    }

    public void setSent(Boolean sent) {
        isSent = sent;
    }

    @Override
    public String toString() {
        return "UserMessage{" +
                "message='" + message + '\'' +
                ", timestamp=" + timestamp +
                ", isSent=" + isSent +
                '}';
    }
}
