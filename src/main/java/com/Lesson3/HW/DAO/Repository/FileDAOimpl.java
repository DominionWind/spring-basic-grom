package com.Lesson3.HW.DAO.Repository;

import com.Lesson3.HW.DAO.Interfeise.FileDAO;
import com.Lesson3.HW.model.File;
import com.Lesson3.HW.model.Storage;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class FileDAOimpl extends GeneralDAOImpl<File> implements FileDAO {

    private String findFilesByStorage = "SELECT * FROM FILE WHERE STORAGE_ID = :storage_id";

    @Override
    public File save(Storage storage, File file) {
        Session session;
        Transaction tr = null;
        try {
            session = createSessionFactory().openSession();
            tr = session.getTransaction();
            tr.begin();
            file.setStorage(storage);
            session.save(file);
            tr.commit();
        } catch (HibernateException e) {
            System.err.println("Save is failed");
            System.err.println(e.getMessage());

            if (tr != null) {
                tr.rollback();
            }
        }
        return file;
    }

    @Override
    public File delete(Storage storage, File file) {
        Session session;
        Transaction tr = null;
        try {
            session = createSessionFactory().openSession();
            tr = session.getTransaction();
            tr.begin();
            session.delete(file);
            tr.commit();
        } catch (Exception e) {
            System.err.println("Delete is failed");
            System.err.println(e.getMessage());

            if (tr != null) {
                tr.rollback();
            }
        }
        return null;
    }

    @Override
    public void transferAll(Storage storageFrom, Storage storageTo) {
        Session session;
        Transaction tr = null;
        try {
            session = createSessionFactory().openSession();
            tr = session.getTransaction();
            tr.begin();
            for (File file:findFilesByStorage(storageFrom)){
                save(storageTo, file);
                delete(storageFrom, file);
            }
            session.getTransaction().commit();
        } catch (Exception e) {
            System.err.println("Transfer files is Failed");
            System.err.println(e.getMessage());

            if (tr != null) {
                tr.rollback();
            }
        }
    }

    @Override
    public File transferFile(Storage storageFrom, Storage storageTo, Long id) {
        Session session;
        Transaction tr = null;
        try {
            session = createSessionFactory().openSession();
            tr = session.getTransaction();
            tr.begin();
            save(storageTo, findById(id));
            delete(storageFrom, findById(id));
            session.getTransaction().commit();
        } catch (Exception e) {
            System.err.println("Transfer " + id + " is Failed");
            System.err.println(e.getMessage());

            if (tr != null) {
                tr.rollback();
            }
        }
        return findById(id);
    }

    @Override
    public List<File> findFilesByStorage(Storage storage) {
        try {
            Session session = createSessionFactory().openSession();
            return (List<File>) session.createNativeQuery(findFilesByStorage)
                    .setParameter("storage_id", storage).addEntity(File.class).list();
        } catch (HibernateException e) {
            System.err.println("Cant get all files from storage " + storage.getId());
            System.err.println(e.getMessage());
        }
        return null;
    }

    @Override
    public List<File> getAllFiles() {
        Session session = null;
        List<File> files = null;
        try {
            session = createSessionFactory().openSession();
            files = session.createQuery("FROM File").list();
        } catch (HibernateException e) {
            System.err.println("Cant get all files");
            System.err.println(e.getMessage());
        }
        return files;
    }
}
