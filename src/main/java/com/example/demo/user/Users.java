package com.example.demo.user;

import com.example.demo.borrowing.BorrowedBook;
import com.example.demo.borrowing.BorrowedBookRepository;

import java.util.List;
import java.util.stream.Collectors;

public class Users {

    private final UserRepository userRepository;
    private final BorrowedBookRepository borrowedBookRepository;

    public Users(UserRepository userRepository, BorrowedBookRepository borrowedBookRepository) {
        this.userRepository = userRepository;
        this.borrowedBookRepository = borrowedBookRepository;
    }

    public List<User> borrowedAtLeastOneBook() {

        List<User> users = userRepository.getAll();

        List<UserId> borrowsIds = borrowedBookRepository.getAll()
                .stream().map(BorrowedBook::getBorrowerId)
                .collect(Collectors.toList());


        return users.stream()
                .filter(user -> borrowsIds.contains(user.getUserId()))
                .collect(Collectors.toList());
    }

    public List<User> nonTerminatedUser() {

        List<User> users = userRepository.getAll();

        List<UserId> borrowsIds = borrowedBookRepository.getAll()
                .stream().map(BorrowedBook::getBorrowerId)
                .collect(Collectors.toList());

        return users.stream()
                .filter(User::activeUser)
                .filter(user -> !borrowsIds.contains(user.getUserId()))
                .collect(Collectors.toList());
    }
}
