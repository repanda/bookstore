package com.example.demo.application;

import com.example.demo.user.User;
import com.example.demo.user.UserId;
import com.example.demo.user.UserRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

public class FakeUserRepository implements UserRepository {

    List<User> repository = new ArrayList<>();

    @Override
    public void addAll(List<User> users) {
        List<User> collect = users.stream()
                .map(user -> {
                            user.setUserId(new UserId(UUID.randomUUID()));
                            return user;
                        }
                ).collect(Collectors.toList());
        repository.addAll(collect);
    }

    @Override
    public List<User> getAll() {
        return repository;
    }
}
