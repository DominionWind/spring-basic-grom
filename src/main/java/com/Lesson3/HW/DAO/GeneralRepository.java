package com.Lesson3.HW.DAO;

import com.sun.xml.internal.ws.handler.HandlerException;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class GeneralRepository<T> {
    private Class<T> tClass;
    private SessionFactory sessionFactory;

    public final void setClass(Class<T> setClass) {
        this.tClass = setClass;
    }

    protected T save(T t) {
        Session session = null;
        Transaction tr = null;
        try {
            session = createSessionFactory().openSession();
            tr = session.getTransaction();
            tr.begin();
            session.save(t);
            tr.commit();
        } catch (HandlerException e) {
            System.err.println("Save is failed");
            System.err.println(e.getMessage());

            if (tr != null) {
                tr.rollback();
            }
        }
        return t;
    }

    protected T update(T t) {
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

    protected void delete(Long id) {
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

    protected T findById(Long id) throws Exception {
        try (Session session = createSessionFactory().openSession()) {
            return session.get(tClass, id);
        } catch (HibernateException e) {
            System.err.println("Can`t find by id " + id);
            System.err.println(e.getMessage());
        }
        return null;
    }

    protected T findByName(String name) throws Exception {
        try (Session session = createSessionFactory().openSession()) {
            return session.get(tClass, name);
        } catch (HibernateException e) {
            System.err.println("Can`t find by name " + name);
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
