package com.example.demo.application;

import com.example.demo.catalog.Book;
import com.example.demo.catalog.BookRepository;

import java.util.ArrayList;
import java.util.List;

public class FakeBookRepository implements BookRepository {

    List<Book> repository = new ArrayList<>();

    @Override
    public List<Book> getAll() {
        return repository;
    }

    @Override
    public void addAll(List<Book> books) {
        repository.addAll(books);
    }

    @Override
    public Book findByTitle(String bookName) {
        return null;
    }
}
