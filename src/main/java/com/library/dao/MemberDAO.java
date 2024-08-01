package com.library.dao;

import org.hibernate.Session;
import com.library.model.Member;

public class MemberDAO {
    public void save(Member member) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            session.save(member);
            session.getTransaction().commit();
        }
    }
}

