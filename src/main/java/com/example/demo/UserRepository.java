package com.example.demo;

import java.util.List;

public interface UserRepository {
    void addAll(List<User> users);

    List<User> getAll();
}
