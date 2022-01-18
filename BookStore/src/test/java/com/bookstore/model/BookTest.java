package com.bookstore.model;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;

import org.junit.Before;
import org.junit.Test;

public class BookTest {

    private Book book;

    @Before
    public void initBook() {
        Author author1 = new Author(1, "Mario", "Rossi");
        Author author2 = new Author(2, "Giovanna", "Bianchi");
        Publisher publisher1 = new Publisher(1, "A Publisher");
        this.book = new Book(1, "Libro 1", new Author[] { author1, author2 }, publisher1, new BigDecimal("10.50"));

    }

    @Test
    public void testAddAuthor() {
        int initialSize = book.getAuthors().length;
        book.addAuthor(new Author(3, "Carlo", "Verdi"));
        assertEquals(initialSize + 1, book.getAuthors().length);
    }

    @Test
    public void testAddCategory() {
        int initialSize = book.getCategories().length;
        book.addCategory(BookCategory.ARTS_AND_PHOTOGRAPY);
        assertEquals(initialSize + 1, book.getCategories().length);
    }

}
