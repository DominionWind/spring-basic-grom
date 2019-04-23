package com.Lesson3.HW.DAO;

public interface GeneralDAO<T> {
    T save();
    T update();
    void delete();
    T findById();
    T findByName();
}
