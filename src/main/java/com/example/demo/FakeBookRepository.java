package com.example.demo;

import java.util.ArrayList;
import java.util.List;

class FakeBookRepository implements BookRepository {

    List<Book> repository = new ArrayList<>();

    @Override
    public List<Book> getAll() {
        return repository;
    }

    @Override
    public void addAll(List<Book> books) {
        repository.addAll(books);
    }
}
