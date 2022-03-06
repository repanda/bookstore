package com.example.demo.user;

import java.util.Date;

public class User {

    private UserId userId;
    private Date memberTill;

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
}
