package org.example.entity;

import java.util.Date;

@SuppressWarnings("all")
/**
 *@BelongsProject: spring-annotation
 *@BelongsPackage: org.example.entity
 *@Author: yinxiaochao
 *@CreateTime: 2023-03-21  09:40
 *@Description: TODO
 *@Version: 1.0
 */
public class Book {
    private String bookName;
    private String author;
    private Double price;

    public Book() {
    }

    public Book(String bookName, String author, Double price) {
        this.bookName = bookName;
        this.author = author;
        this.price = price;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Book{" +
                "bookName='" + bookName + '\'' +
                ", author='" + author + '\'' +
                ", price=" + price +
                '}';
    }
}
