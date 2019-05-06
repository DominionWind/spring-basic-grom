package com.Lesson3.HW.DAO.Interfeise;

import org.hibernate.SessionFactory;

public interface GeneralDAO<T> {
    T save(T t);
    T update(T t);
    void delete(Long id);
    T findById(Long id);
    SessionFactory createSessionFactory();
}
