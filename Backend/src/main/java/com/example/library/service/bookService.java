package com.example.library.service;

import java.util.List;

import com.example.library.Book;
import com.example.library.Repository.BookRepository;

public class bookService {
    private final BookRepository bookRepository;

    public bookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public List<Book> getBooks() {
        return bookRepository.findAll();
    }
}
