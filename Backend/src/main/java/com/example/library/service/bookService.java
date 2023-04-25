package com.example.library.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.library.Repository.BookRepository;
import com.example.library.dto.Book;

@Service
public class BookService {
    private final BookRepository bookRepository;

    @Autowired
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    //Get all books Service
    public List<Book> getBooks() {
        return bookRepository.findAll();
    }

    //Add book Service
    public void addNewBook(Book book) {
        Optional<Book> bookOptional = bookRepository.findBookByTitle(book.getTitle());

        if (bookOptional.isPresent()) {
            throw new IllegalStateException("Book already exists");
        }
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

    //Borrow book Service
    public void borrowBook(Long bookId) {
        Optional<Book> bookOptional = bookRepository.findById(bookId);
        if (bookOptional.isPresent()) {
            Book book = bookOptional.get();
            if (book.getAvailableQuantity().intValue() > 0) {
                book.setAvailableQuantity(book.getAvailableQuantity().intValue() - 1);
                bookRepository.save(book);
            } else {
                throw new IllegalStateException("Book is not available");
            }
        } else {
            throw new IllegalStateException("Book with id " + bookId + " does not exist");
        }
    }

}
