package com.example.library;

import com.example.library.Enum.Category;
import com.example.library.Enum.PackageType;

import jakarta.persistence.Table;

@Table(name = "books")
public class Book {
    private String title;
    private String author;
    private String publishedDate;
    private Category category;
    private PackageType packageType;
    private Number availableQuantity;
    private Number totalQuantity;
    private String coverPage;

    public Book(String string, String string2, String string3, String string4, String string5, String string6){   
    }

    public Book(String title, String author, String publishedDate, Category category, PackageType packageType, Number availableQuantity, Number totalQuantity, String coverPage){
        this.title = title;
        this.author = author;
        this.publishedDate = publishedDate;
        this.category = category;
        this.packageType = packageType;
        this.availableQuantity = availableQuantity;
        this.totalQuantity = totalQuantity;
        this.coverPage = coverPage;
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
    public String getPublishedDate() {
        return publishedDate;
    }
    public void setPublishedDate(String publishedDate) {
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
