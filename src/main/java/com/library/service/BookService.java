package com.library.service;

import com.library.dao.BookDAO; 
import com.library.model.Book;

public class BookService {
    private final BookDAO bookDAO;

    public BookService() {
        bookDAO = new BookDAO();
    }

    public void createBook(Book book) {
        bookDAO.save(book);
    }
}
