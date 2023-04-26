package com.example.library.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.library.Repository.BookRepository;
import com.example.library.Repository.BorrowRepository;
import com.example.library.Repository.UserRepository;
import com.example.library.dto.Book;
import com.example.library.dto.Borrow;
import com.example.library.dto.User;

@Service
public class BookService {
    private final BookRepository bookRepository;
    private final BorrowRepository borrowRepository;

    @Autowired
    public BookService(BookRepository bookRepository, BorrowRepository borrowRepository) {
        this.bookRepository = bookRepository;
        this.borrowRepository = borrowRepository;
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

    // Borrow book Service
    // public void borrowBook(@RequestBody Borrow borrow) {
    //     Date currentDate = new Date();
    //     //Optional<Borrow> borrowOptional = borrowRepository.findByUserId(userId);
    //     // User user = UserRepository.findById(borrow.getUserId()).get();
    //     // Book book = BookRepository.findById(borrow.getBookId()).get();

    //     if (book.getAvailableQuantity().intValue() > 0) {
    //         borrow.setBorrowDate(currentDate);
    //         borrow.setReturnDate(null);
    //         borrowRepository.save(borrow);
    //         book.setAvailableQuantity(book.getAvailableQuantity().intValue() - 1);
    //         bookRepository.save(book);
    //     } else {
    //         throw new IllegalStateException("Book is not available");
    //     }
    // }

       

    // //Return book Service
    // public void returnBook(Long bookId, Long userId) {
    //     Date currentDate = new Date();
    //     Optional<Borrow> borrowOptional = borrowRepository.findByUserId(userId);
    //     Optional<Book> bookOptional = bookRepository.findById(bookId);
    //     if (bookOptional.isPresent()) {
    //         Book book = bookOptional.get();
    //         Borrow borrow = borrowOptional.get();
    //         borrow.setReturnDate(currentDate);
    //         book.setAvailableQuantity(book.getAvailableQuantity().intValue() + 1);
    //         bookRepository.save(book);
    //     } else {
    //         throw new IllegalStateException("Book with id " + bookId + " does not exist");
    //     }
    // }

}

// returnBook(Long bookId) {
//     Date currentDate = new Date();
//     Optional<Book> bookOptional = bookRepository.findById(bookId);
//     if (bookOptional.isPresent()) {
//         Book book = bookOptional.get();
//         book.setReturnDate(currentDate);
//         book.setAvailableQuantity(book.getAvailableQuantity().intValue() + 1);
//         bookRepository.save(book);
//     } else {
//         throw new IllegalStateException("Book with id " + bookId + " does not exist");
//     }
//public void borrowBook(Long userId, Long bookId){
//     Date currentDate = new Date();
//     Optional<Borrow> borrowOptional = borrowRepository.findByBookId(bookId);
//     if (borrowOptional.isPresent()) {
//         throw new IllegalStateException("Book is already borrowed");
//     }
    
// }
// }
