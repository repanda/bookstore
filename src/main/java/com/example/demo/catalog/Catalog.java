package com.example.demo.catalog;

import com.example.demo.borrowing.BorrowedBook;
import com.example.demo.borrowing.BorrowedBookRepository;

import java.util.List;
import java.util.stream.Collectors;

public class Catalog {

    private final BookRepository bookRepository;
    private final BorrowedBookRepository borrowedBookRepository;

    public Catalog(BookRepository bookRepository,
                   BorrowedBookRepository borrowedBookRepository) {

        this.bookRepository = bookRepository;
        this.borrowedBookRepository = borrowedBookRepository;
    }

    public List<Book> getAvailableBooks() {

        List<Book> allBooks = bookRepository.getAll();

        List<BookId> borrowedBookIds = borrowedBookRepository.getAll()
                .stream()
                .map(BorrowedBook::getBookId)
                .collect(Collectors.toList());


        return allBooks.stream()
                .filter(book -> !borrowedBookIds.contains(book.getBookId()))
                .collect(Collectors.toList());
    }
}
