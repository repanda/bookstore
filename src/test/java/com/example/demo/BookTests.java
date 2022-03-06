package com.example.demo;


import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

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

    @Test
    public void availableBooks() {

        Assertions.assertThat(true).isTrue();
    }

    @Test
    public void returnAllBooksWhenNoBooksIsBorrowed() {

        List<Book> books = new ArrayList<>();
        books.add(new Book());
        books.add(new Book());

        BookRepository bookRepository = new FakeBookRepository();
        bookRepository.addAll(books);

        Catalog catalog = new Catalog(bookRepository);

        Assertions
                .assertThat(catalog.getAvailableBooks())
                .hasSize(2);
    }


}
