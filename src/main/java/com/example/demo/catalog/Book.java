package com.example.demo.catalog;

import java.util.UUID;

public class Book {

    private BookId bookId;

    private String title;

    public Book(String title) {
        this.title = title;
        this.bookId = new BookId(UUID.randomUUID());
    }

    public Book(BookId bookId) {
        this.bookId = bookId;
    }

    public BookId getBookId() {
        return bookId;
    }

    public String getTitle() {
        return title;
    }
}
