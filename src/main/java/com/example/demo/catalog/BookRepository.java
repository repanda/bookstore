package com.example.demo.catalog;

import java.util.List;

public interface BookRepository {
    List<Book> getAll();

    void addAll(List<Book> books);

    Book findByTitle(String bookName);
}
