package com.example.library.service;

import java.util.List;

import com.example.library.Book;
import com.example.library.Repository.BookRepository;

public class BookService {
    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    //Get all books
    public List<Book> getBooks() {
        return bookRepository.findAll();
    }

    //Add book
    public void addNewBook(Book book) {
        bookRepository.save(book);
    }

    //Delete book
    public void deleteBook(Long id) {
        boolean exists = bookRepository.existsById(id);
        if (!exists) {
            throw new IllegalStateException("Book with id " + id + " does not exist");
        }
        bookRepository.deleteById(id);
    }

}
