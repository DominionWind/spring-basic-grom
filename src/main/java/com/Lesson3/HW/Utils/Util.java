package com.Lesson3.HW.Utils;

import com.Lesson3.HW.model.File;
import com.Lesson3.HW.model.Storage;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class Util {
    private SessionFactory sessionFactory;

    private String findFilesByStorage = "SELECT * FROM FILE as files WHERE STORAGE_ID = :storage_id";

    public boolean checkSize(Storage storage, File file) {
        List<File> files = findByStorage(storage);
        Long fileSize = null;
        for (File f : files) {
            fileSize += f.getSize();
        }
        if ((fileSize += file.getSize()) < storage.getStorageSize()) {
            return true;
        }
        return false;
    }

    public boolean checkFormatSupported(Storage storage, File file) {
        for (String f : storage.getFormatsSupported()) {
            if (f.equals(file.getFormat())) {
                return true;
            }
        }
        return false;
    }

    public boolean checkExist(Storage storage, File file) {
        List<File> files = findByStorage(storage);
        for (File f : files) {
            if (f.equals(file)) {
                return false;
            }
        }
        return true;
    }

    public List<File> findByStorage(Storage storage) {

        try {
            Session session = createSessionFactory().openSession();
            return (List<File>) session.createNativeQuery(findFilesByStorage)
                    .setParameter("storage_id", storage).addEntity(File.class).list();
        } catch (HibernateException e) {
            e.printStackTrace();
        }
        sessionFactory.close();
        return null;
    }

    private SessionFactory createSessionFactory() {
        if (sessionFactory == null) {
            sessionFactory = new Configuration().configure().buildSessionFactory();
        }
        return sessionFactory;
    }
}
