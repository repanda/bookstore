package com.example.demo;


import com.example.demo.application.FakeBookRepository;
import com.example.demo.application.FakeBorrowedBookRepository;
import com.example.demo.application.FakeUserRepository;
import com.example.demo.borrowing.BorrowedBook;
import com.example.demo.borrowing.BorrowedBookRepository;
import com.example.demo.catalog.Book;
import com.example.demo.catalog.BookId;
import com.example.demo.catalog.BookRepository;
import com.example.demo.catalog.Catalog;
import com.example.demo.user.User;
import com.example.demo.user.UserId;
import com.example.demo.user.UserRepository;
import com.example.demo.user.Users;
import org.junit.jupiter.api.Test;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;

/*
Cutting requirements

a) returns all users who have actually borrowed at least one book (actually!)
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

    final Book javaBook = new Book(new BookId(UUID.randomUUID()));
    final Book goBook = new Book(new BookId(UUID.randomUUID()));
    final Book cssBook = new Book(new BookId(UUID.randomUUID()));

    User FAKE_USER = new User(new UserId(UUID.randomUUID()));

    final BookRepository bookRepository = new FakeBookRepository();
    final BorrowedBookRepository borrowedBookRepository = new FakeBorrowedBookRepository();

    @Test
    public void returnOnlyAvailableBooks() {
        bookRepository.addAll(List.of(javaBook, goBook, cssBook));

        List<BorrowedBook> borrowedBooks = List.of(new BorrowedBook(javaBook.getBookId(), FAKE_USER.getUserId()), new BorrowedBook(goBook.getBookId(), FAKE_USER.getUserId()));
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

    @Test
    public void returnAllUsersWhoHaveActuallyBorrowedAtLeastOneBook() {
        User chish = new User(new UserId(UUID.randomUUID()));
        User odum = new User(new UserId(UUID.randomUUID()));

        final Book javaBook = new Book(new BookId(UUID.randomUUID()));
        final Book goBook = new Book(new BookId(UUID.randomUUID()));

        UserRepository userRepository = new FakeUserRepository();
        userRepository.addAll(List.of(chish, odum));


        List<BorrowedBook> borrowedBooks = List.of(new BorrowedBook(javaBook.getBookId(), chish.getUserId()), new BorrowedBook(goBook.getBookId(), chish.getUserId()));
        borrowedBookRepository.addAll(borrowedBooks);

        Users users = new Users(userRepository, borrowedBookRepository);

        assertThat(users.borrowedAtLeastOneBook())
                .hasSize(1);
    }

    @Test
    public void  returnsAllNonTerminatedUsersWhoHaveNotCurrentlyBorrowedAnything() {
        User borrowerUser = new User(new UserId(UUID.randomUUID()));
        User activeUser = new User(new UserId(UUID.randomUUID()));
        User terminatedUser = new User(new UserId(UUID.randomUUID()), new Date());
        User anotherTerminatedUser = new User(new UserId(UUID.randomUUID()), new Date());

        final Book javaBook = new Book(new BookId(UUID.randomUUID()));
        final Book goBook = new Book(new BookId(UUID.randomUUID()));

        UserRepository userRepository = new FakeUserRepository();
        userRepository.addAll(List.of(borrowerUser, activeUser, terminatedUser, anotherTerminatedUser));


        List<BorrowedBook> borrowedBooks = List.of(new BorrowedBook(javaBook.getBookId(), borrowerUser.getUserId()), new BorrowedBook(goBook.getBookId(), terminatedUser.getUserId()));
        borrowedBookRepository.addAll(borrowedBooks);

        Users users = new Users(userRepository, borrowedBookRepository);

        assertThat(users.nonTerminatedUser())
                .hasSize(1);
    }

}
