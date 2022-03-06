package com.example.demo.user;

import java.util.List;

public interface UserRepository {
    void addAll(List<User> users);

    List<User> getAll();

    User findByName(String userName, String borrowerFistName);
}
