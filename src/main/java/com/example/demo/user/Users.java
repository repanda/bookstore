package com.example.demo.user;

import com.example.demo.borrowing.BorrowedBook;
import com.example.demo.borrowing.BorrowedBookRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class Users {

    private final UserRepository userRepository;
    private final BorrowedBookRepository borrowedBookRepository;

    public Users(UserRepository userRepository, BorrowedBookRepository borrowedBookRepository) {
        this.userRepository = userRepository;
        this.borrowedBookRepository = borrowedBookRepository;
    }

    public List<User> borrowedAtLeastOneBook() {
        List<UserId> borrowersIds = getBorrowersIds();

        return userRepository.getAll()
                .stream()
                .filter(user -> borrowersIds.contains(user.getUserId()))
                .collect(Collectors.toList());
    }

    public List<User> nonTerminatedUser() {
        List<UserId> borrowersIds = getBorrowersIds();

        return userRepository.getAll()
                .stream()
                .filter(User::activeUser)
                .filter(user -> !borrowersIds.contains(user.getUserId()))
                .collect(Collectors.toList());
    }

    private List<UserId> getBorrowersIds() {
        return borrowedBookRepository.getAll()
                .stream().map(BorrowedBook::getBorrowerId)
                .collect(Collectors.toList());
    }
}
