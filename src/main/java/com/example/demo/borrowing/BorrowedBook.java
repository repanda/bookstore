package com.example.demo.borrowing;

import com.example.demo.catalog.BookId;
import com.example.demo.user.UserId;

public class BorrowedBook {

    private BookId bookId;

    private UserId borrowerId;

    public BorrowedBook(BookId bookId, UserId borrowerId) {
        this.bookId = bookId;
        this.borrowerId = borrowerId;
    }

    public BookId getBookId() {
        return bookId;
    }

    public UserId getBorrowerId() {
        return borrowerId;
    }

}
