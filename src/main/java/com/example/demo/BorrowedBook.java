package com.example.demo;

class BorrowedBook {

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
