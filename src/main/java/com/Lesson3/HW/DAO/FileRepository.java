package com.Lesson3.HW.DAO;

import com.Lesson3.HW.model.File;
import org.hibernate.HibernateException;
import org.hibernate.Session;

import java.util.List;

public class FileRepository extends GeneralRepository<File>{

    @Override
    public File save(File file) {
        return super.save(file);
    }

    @Override
    public File update(File file) {
        return super.update(file);
    }

    @Override
    public void delete(Long id) {
        super.delete(id);
    }

    @Override
    public File findById(Long id) throws Exception {
        return super.findById(id);
    }

    @Override
    public File findByName(String name) throws Exception {
        return super.findByName(name);
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
