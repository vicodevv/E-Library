package com.example.library.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.library.dto.Book;
import com.example.library.service.BookService;

@RestController
@RequestMapping(path = "api/books")
@CrossOrigin(origins = "http://localhost:4200")
public class BookController {

    private final BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    //Get all books Controller
    @GetMapping()
    public List<Book> getBooks() {
        return bookService.getBooks();
    }

    //Add book Controller
    @PostMapping()
    public void registerNewBook(@RequestBody Book book) {
        bookService.addNewBook(book);
    }

    //Delete book Controller
    @DeleteMapping("/{bookId}")
        public void deleteBook(@PathVariable Long bookId){
            bookService.deleteBook(bookId);
    }

    //Borrow book Controller
    @PostMapping("/borrow/{userId}/{bookId}")
    public void borrowBook(@PathVariable Long bookId, @PathVariable Long userId){
        bookService.borrowBook(bookId, userId);
    }
    
    @PutMapping("/return/{userId}/{bookId}")
    public void returnBook(@PathVariable Long bookId, @PathVariable Long userId){
        bookService.returnBook(bookId, userId);
    }
}
