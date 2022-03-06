package com.example.demo;

import java.util.ArrayList;
import java.util.List;

class FakeBookRepository implements BookRepository {

    @Override
    public List<Book> getAll() {
        List<Book> books = new ArrayList<>();

        books.add(new Book());
        books.add(new Book());

        return books;
    }
}
