package com.example.demo;

import java.util.List;

class Catalog {

    private final BookRepository bookRepository;

    public Catalog(BookRepository bookRepository) {

        this.bookRepository = bookRepository;
    }

    public List<Book> getAvailableBooks() {

        return bookRepository.getAll();
    }
}
