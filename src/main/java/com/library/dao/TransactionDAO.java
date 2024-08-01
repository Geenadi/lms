package com.library.dao;

import org.hibernate.Session;
import com.library.model.Transaction;

public class TransactionDAO {
    public void save(Transaction transaction) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            session.save(transaction);
            session.getTransaction().commit();
        }
    }

    public void update(Transaction transaction) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}