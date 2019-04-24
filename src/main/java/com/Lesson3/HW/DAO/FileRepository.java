package com.Lesson3.HW.DAO;

import com.Lesson3.HW.model.File;
import com.Lesson3.HW.model.Storage;
import org.hibernate.HibernateException;
import org.hibernate.Session;

import java.util.List;

public class FileRepository extends GeneralRepository<File> implements FileDAO{

    private String findFilesByStorage = "SELECT * FROM FILE as files WHERE STORAGE_ID = :storage_id";

    @Override
    public File save(Storage storage, File file) {
        return null;
    }

    @Override
    public File update(Storage storage, File file) {
        return null;
    }

    @Override
    public void delete(Storage storage, Long id) {

    }

    @Override
    public File findById(Storage storage, Long id) {
        return null;
    }

    @Override
    public File findByName(Storage storage, String name) {
        return null;
    }

    @Override
    public List<File> getFilesByStorageId(Long id) {
        return null;
    }

    public List<File> findFilesByStorage(Storage storage) {
        try {
            Session session = createSessionFactory().openSession();
            return (List<File>) session.createNativeQuery(findFilesByStorage)
                    .setParameter("storage_id", storage).addEntity(File.class).list();
        } catch (HibernateException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<File> getAllItem() {
        Session session = null;
        List<File> files = null;
        try {
            session = createSessionFactory().openSession();
            files = session.createQuery("FROM File").list();
        } catch (HibernateException e) {
            System.err.println("Cant get all Item");
            System.err.println(e.getMessage());
        }
        return files;
    }
}
