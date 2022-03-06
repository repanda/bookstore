package com.example.demo;

import java.util.List;

public interface BookRepository {
    List<Book> getAll();

    void addAll(List<Book> books);
}
