package com.example.library;

public class Book {
    private String title;
    private String author;
    private String publishedDate;
    private Enum<E> Category;
    private Enum<E> packageType;
    private Number availableQuantity;
    private Number totalQuantity;
    private String coverPage;

    public Book(){   
    }

    public Book(String title, String author, String publishedDate, Enum<E> Category, Enum<E> packageType, Number availableQuantity, Number totalQuantity, String coverPage){
        this.title = title;
        this.author = author;
        this.publishedDate = publishedDate;
        this.Category = Category;
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
    public Enum<E> getCategory() {
        return Category;
    }
    public void setCategory(Enum<E> Category) {
        this.Category = Category;
    }

    // Getters and Setters for packageType
    public Enum<E> getPackageType() {
        return packageType;
    }
    public void setPackageType(Enum<E> packageType) {
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
