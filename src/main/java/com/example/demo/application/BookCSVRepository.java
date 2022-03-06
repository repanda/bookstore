package com.example.demo.application;

import com.example.demo.catalog.Book;
import com.example.demo.catalog.BookRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@Repository
class BookCSVRepository implements BookRepository {

    List<Book> books;

    @Override
    public List<Book> getAll() {
        if (books != null) return books;

        List<List<String>> data = CSVMapper.mapCsvFile("books.csv");

        books = data.stream()
                .map(row -> new Book(row.get(0))
                )
                .collect(Collectors.toList());
        return books;
    }

    @Override
    public void addAll(List<Book> books) {

    }

    @Override
    public Book findByTitle(String title) {
        return getAll()
                .stream()
                .filter(book -> book.getTitle().equals(title))
                .findFirst()
                .orElse(new Book("UNKNOWN"));
    }
}
