package com.example.demo.catalog;

public class Book {

    private BookId bookId;

    public Book(BookId bookId) {
        this.bookId = bookId;
    }

    public BookId getBookId() {
        return bookId;
    }

}
