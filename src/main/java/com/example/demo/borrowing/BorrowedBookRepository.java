package com.example.demo.borrowing;

import java.util.List;

public interface BorrowedBookRepository {
    List<BorrowedBook> getAll();

    void addAll(List<BorrowedBook> borrowedBooks);
}
