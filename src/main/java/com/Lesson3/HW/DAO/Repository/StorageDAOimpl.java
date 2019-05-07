package com.Lesson3.HW.DAO.Repository;

import com.Lesson3.HW.model.Storage;

public class StorageDAOimpl extends GeneralDAOImpl<Storage> {

    public StorageDAOimpl() {
        setClass(Storage.class);
    }
    public Storage saveStorage(Storage storage){
        return save(storage);
    }
    public Storage updateStorage(Storage storage){
        return update(storage);
    }
    public void deleteStorage(Long id){
        delete(id);
    }
    public Storage findStorageById(Long id){
        return findById(id);
    }
}
