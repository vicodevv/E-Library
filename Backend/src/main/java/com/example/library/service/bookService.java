package com.example.library.service;

import java.util.List;

import com.example.library.Book;
import com.example.library.Repository.BookRepository;

public class BookService {
    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    //Get all books Service
    public List<Book> getBooks() {
        return bookRepository.findAll();
    }

    //Add book Service
    public void addNewBook(Book book) {
        bookRepository.save(book);
    }

    //Delete book Service
    public void deleteBook(Long bookId) {
        boolean exists = bookRepository.existsById(bookId);
        if (!exists) {
            throw new IllegalStateException("Book with id " + bookId + " does not exist");
        }
        bookRepository.deleteById(bookId);
    }

}
