package com.example.demo;

class BorrowedBook {

    private BookId bookId;

    public BorrowedBook(BookId bookId) {
        this.bookId = bookId;
    }

    public BookId getBookId() {
        return bookId;
    }

    public void setBookId(BookId bookId) {
        this.bookId = bookId;
    }
}
