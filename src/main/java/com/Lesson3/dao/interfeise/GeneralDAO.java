package com.Lesson3.dao.interfeise;

import com.Lesson3.exeptions.InternalExeption;
import org.hibernate.SessionFactory;

public interface GeneralDAO<T> {
    T save(T t) throws InternalExeption;
    T update(T t) throws InternalExeption;
    void delete(Long id) throws InternalExeption;
    T findById(Long id) throws InternalExeption;
    SessionFactory createSessionFactory();
}
