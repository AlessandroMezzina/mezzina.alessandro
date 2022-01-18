package com.bookstore.App;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;

import com.bookstore.model.Author;
import com.bookstore.model.Book;
import com.bookstore.model.Publisher;

import org.junit.Before;
import org.junit.Test;


public class BookStoreTest {
    private BookStore bookStore;

    @Before
    public void populateBookstore() {
        Author author1 = new Author(1, "Mario", "Rossi");
        Author author2 = new Author(2, "Giovanna", "Bianchi");
        Author author3 = new Author(3, "Carlo", "Verdi");
        Publisher publisher1 = new Publisher(1, "A Publisher");
        Book book1 = new Book(1, "Libro 1", new Author[] {author1, author2}, publisher1, new BigDecimal("10.50"));
        Book book2 = new Book(2, "Libro 2", new Author[] {author3}, publisher1, new BigDecimal("5.25"));
        Book book3 = new Book(3, "Another", new Author[] {author2}, publisher1, new BigDecimal("4.25"));
        this.bookStore = new BookStore();
        this.bookStore.addBook(book1);
        this.bookStore.addBook(book2);
        this.bookStore.addBook(book3);
    }

    @Test
    public void testAddBook() {
        int initialSize = this.bookStore.books.length;
        Author author1 = new Author(1, "Maria", "Neri");
        Author author2 = new Author(2, "Luca", "Morini");
        Publisher publisher1 = new Publisher(1, "Another Publisher");
        Book book = new Book(100, "Libro 3", new Author[] {author1, author2}, publisher1, new BigDecimal("4.99"));
        this.bookStore.addBook(book);
        assertEquals(initialSize + 1, this.bookStore.books.length);
    }

    @Test
    public void testRemoveBook() {
        int initialSize = this.bookStore.books.length;
        this.bookStore.removeBook(new Book(1, "Not important", null));
        assertEquals(initialSize - 1, this.bookStore.books.length);
    }

    @Test
    public void testSearchBookByAuthor() {
        Book[] searched = this.bookStore.searchBookByAuthor(new Author(2, "Not", "Important"));
        assertEquals(2, searched.length);
    }
}
