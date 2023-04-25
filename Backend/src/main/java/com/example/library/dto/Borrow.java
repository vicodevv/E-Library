package com.example.library.dto;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@EntityListeners(AuditingEntityListener.class)
@Table
public class Borrow {
    @Id
    @SequenceGenerator(
            name = "book_sequence",
            sequenceName = "book_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "book_sequence"
    )
    // @OneToOne(targetEntity = User.class, optional = false)
    // @JoinColumn(name = "userId", referencedColumnName = "userId")
    private Long userId;
    private Long bookId;
    @CreatedDate
    private Date borrowDate;
    private Date returnDate;

    public Borrow(){   
    }

    public Borrow(Long userId, Long bookId, Date borrowDate, Date returnDate){
        this.userId = userId;
        this.bookId = bookId;
        this.borrowDate = borrowDate;
        this.returnDate = returnDate;
    }

    public Borrow(Long bookId, Date borrowDate, Date returnDate){
        this.bookId = bookId;
        this.borrowDate = borrowDate;
        this.returnDate = returnDate;
    }

    // Getters and Setters for userId
    public Long getUserId() {
        return userId;
    }
    public void setUserId(Long userId) {
        this.userId = userId;
    }

    //Getters and Setters for boookId
    public Long getBookId(){
        return bookId;
    }
    public void setBookId(Long bookId){
        this.bookId = bookId;
    }

    //Getters and Setters for borrowDate
    public Date getBorrowDate(){
        return borrowDate;
    }
    public void setBorrowDate(Date borrowDate){
        this.borrowDate = borrowDate;
    }

    //Getters and Setters for returnDate
    public Date getReturnDate(){
        return returnDate;
    }
    public void setReturnDate(Date returnDate){
        this.returnDate = returnDate;
    }

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