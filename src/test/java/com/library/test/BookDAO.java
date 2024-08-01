package com.library.test;

import org.hibernate.Session;

import com.library.model.Book;

public class BookDAO {
    public void save(Book book) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            session.save(book);
            session.getTransaction().commit();
        }
    }
}
