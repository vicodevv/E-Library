package com.example.library.controller;

import java.util.List;

import com.example.library.Book;

public class bookController {

    public List<Book> getBooks() {
        return List.of(
            new Book("Harry Potter", "J.K. Rowling", "1234567890", "Fantasy", "English", "123 Main St")
        );
    }
    
}
