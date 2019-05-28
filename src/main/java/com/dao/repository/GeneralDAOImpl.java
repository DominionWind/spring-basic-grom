package com.dao.repository;

import com.dao.interfeise.GeneralDAO;
import com.exeptions.InternalExeption;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Repository;

@Repository
@javax.transaction.Transactional
public abstract class GeneralDAOImpl<T> implements GeneralDAO<T> {

    private Class<T> tClass;

    private SessionFactory sessionFactory;

    public void setClass(Class<T> setClass) {
        this.tClass = setClass;
    }

    @Override
    public T save(T t) throws InternalExeption {
        Transaction tr = null;
        try {
            Session session = createSessionFactory().openSession();
            tr = session.getTransaction();
            tr.begin();
            session.save(t);
            tr.commit();
        } catch (HibernateException e) {
            if (tr != null) {
                tr.rollback();
            }
            System.err.println(e.getMessage());
            throw new InternalExeption("Can`t save " + getClass().getName());
        }
        return t;
    }

    @Override
    public T update(T t) throws InternalExeption {
        Transaction tr = null;
        try {
            Session session = createSessionFactory().openSession();
            tr = session.getTransaction();
            tr.begin();
            session.update(t);
            tr.commit();
        } catch (HibernateException e) {
            if (tr != null) {
                tr.rollback();
            }
            System.err.println(e.getMessage());
            throw new InternalExeption("Can`t update " + getClass().getName());
        }
        return t;
    }

    @Override
    public void delete(Long id) throws InternalExeption {
        Transaction tr = null;
        try {
            Session session = createSessionFactory().openSession();
            tr = session.getTransaction();
            tr.begin();
            session.delete(findById(id));
            tr.commit();
        } catch (Exception e) {
            if (tr != null) {
                tr.rollback();
            }
            System.err.println(e.getMessage());
            throw new InternalExeption("Can`t delete " + getClass().getName() + " " + id);
        }
    }

    public T findById(Long id) throws InternalExeption {
        try (Session session = createSessionFactory().openSession()) {
            return session.get(tClass, id);
        } catch (HibernateException e) {
            System.err.println(e.getMessage());
            throw new InternalExeption("Can`t find " + getClass().getName() + " " + id);
        }
    }

    public SessionFactory createSessionFactory() {
        if (sessionFactory == null) {
            sessionFactory = new Configuration().configure().buildSessionFactory();
        }
        return sessionFactory;
    }
}
