package com.example.demo.application;

import com.example.demo.borrowing.BorrowedBook;
import com.example.demo.borrowing.BorrowedBookRepository;

import java.util.ArrayList;
import java.util.List;

public class FakeBorrowedBookRepository implements BorrowedBookRepository {

    List<BorrowedBook> repository = new ArrayList<>();

    @Override
    public List<BorrowedBook> getAll() {
        return repository;
    }

    @Override
    public void addAll(List<BorrowedBook> borrowedBooks) {
        repository.addAll(borrowedBooks);
    }
}
