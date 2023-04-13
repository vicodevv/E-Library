package com.example.library.dto;

import java.time.LocalDate;

import com.example.library.Enum.Category;
import com.example.library.Enum.PackageType;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table
public class Book {
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
    private Long bookId;
    private String title;
    private String author;
    private LocalDate publishedDate;
    private Category category;
    private PackageType packageType;
    private Number availableQuantity;
    private Number totalQuantity;
    private String coverPage;

    public Book(){   
    }

    public Book(Long bookId, String title, String author, LocalDate publishedDate, Category category, PackageType packageType, Number availableQuantity, Number totalQuantity, String coverPage){
        this.bookId = bookId;
        this.title = title;
        this.author = author;
        this.publishedDate = publishedDate;
        this.category = category;
        this.packageType = packageType;
        this.availableQuantity = availableQuantity;
        this.totalQuantity = totalQuantity;
        this.coverPage = coverPage;
    }

    public Book(String title, String author, LocalDate publishedDate, Category category, PackageType packageType, Number availableQuantity, Number totalQuantity, String coverPage){
        this.title = title;
        this.author = author;
        this.publishedDate = publishedDate;
        this.category = category;
        this.packageType = packageType;
        this.availableQuantity = availableQuantity;
        this.totalQuantity = totalQuantity;
        this.coverPage = coverPage;
    }

    // Getters and Setters for bookId
    public Long getbookId() {
        return bookId;
    }
    public void setId(Long bookId) {
        this.bookId = bookId;
    }

    // Getters and Setters for title
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }

    // Getters and Setters for author
    public String getAuthor() {
        return author;
    }
    public void setAuthor(String author) {
        this.author = author;
    }

    // Getters and Setters for publishedDate
    public LocalDate getPublishedDate() {
        return publishedDate;
    }
    public void setPublishedDate(LocalDate publishedDate) {
        this.publishedDate = publishedDate;
    }

    // Getters and Setters for Category
    public Category getCategory() {
        return category;
    }
    public void setCategory(Category category) {
        this.category = category;
    }

    // Getters and Setters for packageType
    public PackageType getPackageType() {
        return packageType;
    }
    public void setPackageType(PackageType packageType) {
        this.packageType = packageType;
    }


    // Getters and Setters for availableQuantity
    public Number getAvailableQuantity() {
        return availableQuantity;
    }
    public void setAvailableQuantity(Number availableQuantity) {
        this.availableQuantity = availableQuantity;
    }

    // Getters and Setters for totalQuantity
    public Number getTotalQuantity() {
        return totalQuantity;
    }
    public void setTotalQuantity(Number totalQuantity) {
        this.totalQuantity = totalQuantity;
    }

    // Getters and Setters for coverPage
    public String getCoverPage() {
        return coverPage;
    }
    public void setCoverPage(String coverPage) {
        this.coverPage = coverPage;
    }
}
