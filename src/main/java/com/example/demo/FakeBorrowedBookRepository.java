package com.example.demo;

import java.util.ArrayList;
import java.util.List;

class FakeBorrowedBookRepository implements BorrowedBookRepository {

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
