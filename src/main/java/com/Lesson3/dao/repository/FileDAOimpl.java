package com.Lesson3.dao.repository;

import com.Lesson3.dao.interfeise.FileDAO;
import com.Lesson3.exeptions.InternalExeption;
import com.Lesson3.model.File;
import com.Lesson3.model.Storage;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@javax.transaction.Transactional
public class FileDAOimpl extends GeneralDAOImpl<File> implements FileDAO {

    public FileDAOimpl(){
        setClass(File.class);
    }

    private String findFilesByStorage = "SELECT * FROM FILES WHERE STORAGE_ID = ?";

    @Override
    public File save(Storage storage, File file) throws InternalExeption {
        Transaction tr = null;
        try {
            Session session = createSessionFactory().openSession();
            tr = session.getTransaction();
            tr.begin();
            file.setStorage(storage);
            session.save(file);
            tr.commit();
        } catch (HibernateException e) {
            if (tr != null) {
                tr.rollback();
            }
            System.err.println(e.getMessage());
            throw new InternalExeption("File " + file.getId() + " doesn't save in Storage " + storage.getId());
        }
        return file;
    }

    @Override
    public File delete(Storage storage, File file) throws InternalExeption {
        Transaction tr = null;
        try {
            Session session = createSessionFactory().openSession();
            tr = session.getTransaction();
            tr.begin();
            session.delete(file);
            tr.commit();
        } catch (Exception e) {
            if (tr != null) {
                tr.rollback();
            }
            System.err.println(e.getMessage());
            throw new InternalExeption("File " + file.getId() + " doesn't delete from Storage " + storage.getId());
        }
        return null;
    }

    @Override
    public void transferAll(Storage storageFrom, Storage storageTo) throws InternalExeption {
        Transaction tr = null;
        try {
            Session session = createSessionFactory().openSession();
            tr = session.getTransaction();
            tr.begin();
            for (File file : findFilesByStorage(storageFrom)) {
                save(storageTo, file);
                delete(storageFrom, file);
            }
            session.getTransaction().commit();
        } catch (Exception e) {
            if (tr != null) {
                tr.rollback();
            }
            System.err.println(e.getMessage());
            throw new InternalExeption("Transfer files from Storage " + storageFrom.getId() + " failed to Storage " + storageTo.getId());
        }
    }

    @Override
    public File transferFile(Storage storageFrom, Storage storageTo, Long id) throws InternalExeption {
        Transaction tr = null;
        try {
            Session session = createSessionFactory().openSession();
            tr = session.getTransaction();
            tr.begin();
            save(storageTo, findById(id));
            delete(storageFrom, findById(id));
            session.getTransaction().commit();
        } catch (Exception e) {
            if (tr != null) {
                tr.rollback();
            }
            throw new InternalExeption("Transfer File" + id + " from Storage " + storageFrom.getId() + " to Storage "
                    + storageTo.getId() + " is Failed");
        }
        return findById(id);
    }

    @Override
    public List<File> findFilesByStorage(Storage storage) {
        try {
            Session session = createSessionFactory().openSession();
            return (List<File>) session.createNativeQuery(findFilesByStorage)
                    .setParameter(1, storage).addEntity(File.class).list();
        } catch (HibernateException e) {
            System.err.println("Cant get all files from storage " + storage.getId());
            System.err.println(e.getMessage());
        }
        return null;
    }

    @Override
    public List getAllFiles() {
        List files = null;
        try {
            Session session = createSessionFactory().openSession();
            files = session.createQuery("FROM File").list();
        } catch (HibernateException e) {
            System.err.println("Cant get all files");
            System.err.println(e.getMessage());
        }
        return files;
    }
}
