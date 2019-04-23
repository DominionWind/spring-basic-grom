package com.Lesson3.HW.DAO;

import com.Lesson3.HW.model.Storage;
import org.hibernate.HibernateException;
import org.hibernate.Session;

import java.util.List;

public class StorageRepository extends GeneralRepository<Storage>{
    @Override
    protected Storage save(Storage storage) {
        return super.save(storage);
    }

    @Override
    protected Storage update(Storage storage) {
        return super.update(storage);
    }

    @Override
    protected void delete(Long id) {
        super.delete(id);
    }

    @Override
    protected Storage findById(Long id) throws Exception {
        return super.findById(id);
    }

    @Override
    protected Storage findByName(String name) throws Exception {
        return super.findByName(name);
    }

    List<Storage> getAllItem() {
        Session session = null;
        List<Storage> storages = null;
        try {
            session = createSessionFactory().openSession();
            storages = session.createQuery("FROM Storage").list();
        } catch (HibernateException e) {
            System.err.println("Cant get all Item");
            System.err.println(e.getMessage());
        }
        return storages;
    }



}



