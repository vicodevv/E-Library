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
}
