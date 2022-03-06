package com.example.demo;

import java.util.List;

public interface BorrowedBookRepository {
    List<BorrowedBook> getAll();

    void addAll(List<BorrowedBook> borrowedBooks);
}
