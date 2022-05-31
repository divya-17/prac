package com.example.chatdemo.model;

import javax.persistence.*;

@Entity
@Table(name="messages")
public class Message {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Column(name="message")
    private String message;

    @Column(name="timestamp")
    private long timestamp;

    @Column(name="is_sent")
    private boolean isSent;


    public Message() {
    }

    public Message(long id, User user, String message, long timestamp, boolean isSent) {
        this.id = id;
        this.user = user;
        this.message = message;
        this.timestamp = timestamp;
        this.isSent = isSent;
    }

    public Message(User user, String message, boolean isSent) {
        System.out.println("Inside Message constructor");
        System.out.println("Setting user =>"+user);
        System.out.println("Setting message => "+message);
        System.out.println("Setting isSent => "+isSent);
        this.user = user;
        this.message = message;
        this.timestamp = System.currentTimeMillis();
        this.isSent = isSent;
    }
    public Message(User user, String message) {
        this.user = user;
        this.message = message;
        this.timestamp = System.currentTimeMillis();
        this.isSent = true;
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
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

    public boolean isSent() {
        return isSent;
    }

    public void setSent(boolean sent) {
        isSent = sent;
    }

    @Override
    public String toString() {
        return "Message{" +
                "id=" + id +
                ", user=" + user +
                ", message='" + message + '\'' +
                ", timestamp=" + timestamp +
                ", isSent=" + isSent +
                '}';
    }
}
