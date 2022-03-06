package com.example.demo;

import java.util.List;
import java.util.stream.Collectors;

class Catalog {

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
