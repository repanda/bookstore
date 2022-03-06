package com.example.demo;


import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/*
Cutting requirements

a) returns all users who have actually borrowed at least one book
 in (borrowedBooks)   => function:: ( checkBorrowedBooks ) => out ( Users )

b) returns all non-terminated users who have not currently borrowed anything
 users + borrowedBooks  => :: filter on non-terminated  +  not currently borrowed anything =>  non-terminated users

c) returns all users who have borrowed a book on a given date
a date + users + borrowedBooks => checkBorrowedBooks by user on date => users (a date range or a specific date or the starting date ? )

d) returns all books borrowed by a given user in a given date range
a date range + user + borrowedBooks => checkBorrowedBooks by user in a date range => books

e) returns all available (not borrowed) books
books + borrowedBooks => books

 */
public class BookTests {

    final Book javaBook = new Book(new BookId());
    final Book goBook = new Book(new BookId());
    final Book cssBook = new Book(new BookId());

    final BookRepository bookRepository = new FakeBookRepository();
    final BorrowedBookRepository borrowedBookRepository = new FakeBorrowedBookRepository();

    @Test
    public void returnOnlyAvailableBooks() {
        bookRepository.addAll(List.of(javaBook, goBook, cssBook));

        List<BorrowedBook> borrowedBooks = List.of(new BorrowedBook(javaBook.getBookId()), new BorrowedBook(goBook.getBookId()));
        borrowedBookRepository.addAll(borrowedBooks);

        Catalog catalog = new Catalog(bookRepository, borrowedBookRepository);

        assertThat(catalog.getAvailableBooks())
                .hasSize(1);
    }

    @Test
    public void returnAllBooksWhenNoBooksIsBorrowed() {

        bookRepository.addAll(List.of(javaBook, goBook));

        Catalog catalog = new Catalog(bookRepository, new FakeBorrowedBookRepository());

        assertThat(catalog.getAvailableBooks())
                .hasSize(2);
    }


}
