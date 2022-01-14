package com.bookstore.model;
import java.math.BigDecimal;
import java.util.Arrays;

public class Book{
    private long id;
    private String title;
    private BigDecimal price; //BigDecimal é un oggetto che serve per rappresentare double ma con una migliore precisione
    private Author[] authors;
    private Publisher publisher;

    public Book(long id, String title, Author[] authors) {
        this.id=id;
        this.title=title;
        this.authors=authors;
    }

    public Book(long id, String title, Author[] authors, BigDecimal price) {
        this.id=id;
        this.title=title;
        this.authors=authors;
        this.price=price;
    }


    public Book(long id, String title, Author[] authors, Publisher publisher, BigDecimal price) {
        this.id = id;
        this.title = title;
        this.price = price;
        this.authors = authors;
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

    public Author[] getAuthors() {
        return authors;
    }
    public void setAuthor(Author[] authors) {
        this.authors=authors;
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
            ", authors='" + getAuthors() + "'" +
            ", publisher='" + getPublisher() + "'" +
            "}";
    }
    

    public void addAuthor(Author add) {
        authors=Arrays.copyOf(authors, authors.length+1);
        authors[authors.length-1]=add;
    }
}