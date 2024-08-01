package com.library.controller;

import com.library.model.Book;
import com.library.service.BookService;


public class BookController {
    private final BookService bookService;

    public BookController() {
        bookService = new BookService();
    }

    public void createBook(Book book) {
        bookService.createBook(book);
    }
}