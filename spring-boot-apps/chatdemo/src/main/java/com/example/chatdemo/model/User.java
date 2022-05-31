package com.example.chatdemo.model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name="users")

public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="userId")
    private long userId;

    @Column(name="user")
    private String userName;


    @OneToMany(mappedBy = "user",fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    private Set<Message> messageList;

    public User() {
    }


    public User(long userId, String userName) {
        this.userId = userId;
        this.userName = userName;
    }

    public User(String userName) {
        this.userName = userName;
    }


    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Set<Message> getMessageList() {
        return messageList;
    }

    public void setMessageList(Set<Message> messageList) {
        this.messageList = messageList;
    }
}
