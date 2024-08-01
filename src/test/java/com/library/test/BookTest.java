package com.library.test;

import com.library.dao.BookDAO;
import com.library.model.Book;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class BookTest {
    private BookDAO bookDAO;

    @Before
    public void setUp() {
        bookDAO = new BookDAO();
    }

    @After
    public void tearDown() {
    }

    @Test
    public void testSaveBook() {
        Book book = new Book("Test Book", "Test Author", "Test Category");
        bookDAO.save(book);

        Book savedBook = bookDAO.get(book.getId());
        assertNotNull(savedBook);
        assertEquals(book.getTitle(), savedBook.getTitle());
        assertEquals(book.getAuthor(), savedBook.getAuthor());
        assertEquals(book.getCategory(), savedBook.getCategory());
    }

    @Test
    public void testUpdateBook() {
        Book book = new Book("Test Book", "Test Author", "Test Category");
        bookDAO.save(book);

        book.setTitle("Updated Book");
        book.setAuthor("Updated Author");
        book.setCategory("Updated Category");
        bookDAO.update(book);

        Book updatedBook = bookDAO.get(book.getId());
        assertEquals("Updated Book", updatedBook.getTitle());
        assertEquals("Updated Author", updatedBook.getAuthor());
        assertEquals("Updated Category", updatedBook.getCategory());
    }

    @Test
    public void testDeleteBook() {
        Book book = new Book("Test Book", "Test Author", "Test Category");
        bookDAO.save(book);

        bookDAO.delete(book.getId());
        Book deletedBook = bookDAO.get(book.getId());
        assertNull(deletedBook);
    }
}