package com.library.dao;

import org.hibernate.Session;
import com.library.model.Category;

public class CategoryDAO {
    public void save(Category category) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            session.save(category);
            session.getTransaction().commit();
        }
    }
}