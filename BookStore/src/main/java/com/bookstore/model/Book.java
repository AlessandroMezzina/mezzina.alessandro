package com.bookstore.model;
import java.math.BigDecimal;

public class Book{
    private long id;
    private String title;
    private BigDecimal price; //BigDecimal é un oggetto che serve per rappresentare double ma con una migliore precisione
    Author author;
    Publisher publisher;

    public Book(long id, String title, Author author) {
        this.id=id;
        this.title=title;
        this.author=author;
    }

    public Book(long id, String title, Author author, BigDecimal price) {
        this.id=id;
        this.title=title;
        this.author=author;
        this.price=price;
    }


    public Book(long id, String title, Author author, Publisher publisher, BigDecimal price) {
        this.id = id;
        this.title = title;
        this.price = price;
        this.author = author;
        this.publisher = publisher;
    }

    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id=id;
    }

    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title=title;
    }

    public BigDecimal getPrice() {
        return price;
    }
    public void setPrice(BigDecimal price) {
        this.price=price;
    }

    public Author getAuthor() {
        return author;
    }
    public void setAuthor(Author author) {
        this.author=author;
    }


    public Publisher getPublisher() {
        return this.publisher;
    }

    public void setPublisher(Publisher publisher) {
        this.publisher = publisher;
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", title='" + getTitle() + "'" +
            ", price='" + getPrice() + "'" +
            ", author='" + getAuthor() + "'" +
            ", publisher='" + getPublisher() + "'" +
            "}";
    }  
}