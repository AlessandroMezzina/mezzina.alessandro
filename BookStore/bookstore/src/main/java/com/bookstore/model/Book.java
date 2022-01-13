package com.bookstore.model;
import java.math.BigDecimal;

public class Book{
    private long id;
    private String title;
    private BigDecimal price; //BigDecimal é un oggetto che serve per rappresentare double ma con una migliore precisione
    private String author;

    public Book(long id, String title, String author) {
        this.id=id;
        this.title=title;
        this.author=author;
    }

    public Book(long id, String title, String author, BigDecimal price) {
        this.id=id;
        this.title=title;
        this.author=author;
        this.price=price;
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

    public String getAuthor() {
        return author;
    }
    public void setAuthor(String author) {
        this.author=author;
    }


    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", title='" + getTitle() + "'" +
            ", price='" + getPrice() + "'" +
            ", author='" + getAuthor() + "'" +
            "}";
    }
    

}