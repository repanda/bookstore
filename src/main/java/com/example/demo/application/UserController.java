package com.example.demo.application;


import com.example.demo.user.User;
import com.example.demo.user.Users;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
class UserController {

    final Users users;

    UserController(Users users) {
        this.users = users;
    }

    @GetMapping("/borrowedAtLeastOneBook")
    public List<User> borrowedAtLeastOneBook() {

        return users.borrowedAtLeastOneBook();
    }
}
