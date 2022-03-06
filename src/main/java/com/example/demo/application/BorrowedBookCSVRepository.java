package com.example.demo.application;

import com.example.demo.borrowing.BorrowedBook;
import com.example.demo.borrowing.BorrowedBookRepository;
import com.example.demo.catalog.Book;
import com.example.demo.catalog.BookRepository;
import com.example.demo.user.User;
import com.example.demo.user.UserRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@Repository
class BorrowedBookCSVRepository implements BorrowedBookRepository {

    List<BorrowedBook> borrowedBooks;

    final UserRepository userRepository;
    final BookRepository bookRepository;

    BorrowedBookCSVRepository(UserRepository userRepository, BookRepository bookRepository) {
        this.userRepository = userRepository;
        this.bookRepository = bookRepository;
    }

    @Override
    public List<BorrowedBook> getAll() {
        if (borrowedBooks != null) return borrowedBooks;

        List<List<String>> data = CSVMapper.mapCsvFile("borrowed.csv");

        borrowedBooks = data.stream()
                .map(this::createBorrowedBook)
                .collect(Collectors.toList());
        return borrowedBooks;
    }

    private BorrowedBook createBorrowedBook(List<String> row) {
        String borrowerName = row.get(0);
        String borrowerFistName = row.get(1);
        User user = this.userRepository.findByName(borrowerName, borrowerFistName);

        String bookName = row.get(2);
        Book book = this.bookRepository.findByTitle(bookName);

        return new BorrowedBook(
                book.getBookId(),
                user.getUserId()
        );
    }

    @Override
    public void addAll(List<BorrowedBook> borrowedBooks) {

    }
}
