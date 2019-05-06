package com.Lesson3.HW.DAO.Repository;

import com.Lesson3.HW.DAO.Interfeise.GeneralDAO;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public abstract class GeneralDAOImpl<T> implements GeneralDAO<T> {

    private Class<T> tClass;

    private SessionFactory sessionFactory;

    public void setClass(Class<T> setClass) {
        this.tClass = setClass;
    }

    @Override
    public T save(T t) {
        Session session;
        Transaction tr = null;
        try {
            session = createSessionFactory().openSession();
            tr = session.getTransaction();
            tr.begin();
            session.save(t);
            tr.commit();
        } catch (HibernateException e) {
            System.err.println("Save is failed");
            System.err.println(e.getMessage());

            if (tr != null) {
                tr.rollback();
            }
        }
        return t;

    }

    @Override
    public T update(T t) {
        Session session = null;
        Transaction tr = null;
        try {
            session = createSessionFactory().openSession();
            tr = session.getTransaction();
            tr.begin();
            session.update(t);
            tr.commit();
        } catch (HibernateException e) {
            System.err.println("Update is failed");
            System.err.println(e.getMessage());

            if (tr != null) {
                tr.rollback();
            }
        }
        return t;
    }

    @Override
    public void delete(Long id) {
        Session session;
        Transaction tr = null;
        try {
            session = createSessionFactory().openSession();
            tr = session.getTransaction();
            tr.begin();
            session.delete(findById(id));
            tr.commit();
        } catch (Exception e) {
            System.err.println("Delete is failed");
            System.err.println(e.getMessage());

            if (tr != null) {
                tr.rollback();
            }
        }
    }

    public T findById(Long id) {
        try (Session session = createSessionFactory().openSession()) {
            return session.get(tClass, id);
        } catch (HibernateException e) {
            System.err.println("Can`t find by id " + id);
            System.err.println(e.getMessage());
        }
        return null;
    }

    public SessionFactory createSessionFactory() {
        if (sessionFactory == null) {
            sessionFactory = new Configuration().configure().buildSessionFactory();
        }
        return sessionFactory;
    }


}
