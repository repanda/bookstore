package com.example.demo.user;

import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

public class User implements Serializable {

    private UserId userId;
    private Date memberTill;

    private String name;
    private String firstName;

    public User(String name, String firstName, Date memberTill) {
        this.name = name;
        this.firstName = firstName;
        this.memberTill = memberTill;
        this.userId = new UserId(UUID.randomUUID());
    }

    public User(UserId userId) {
        this.userId = userId;
        this.memberTill = null;
    }

    public User(UserId userId, Date memberTill) {
        this.userId = userId;
        this.memberTill = memberTill;
    }

    public UserId getUserId() {
        return userId;
    }

    public void setUserId(UserId userId) {
        this.userId = userId;
    }

    /**
     * Non terminated user
     */
    public boolean activeUser() {
        return memberTill == null;
    }

    public String getName() {
        return name;
    }

    public String getFirstName() {
        return firstName;
    }
}
