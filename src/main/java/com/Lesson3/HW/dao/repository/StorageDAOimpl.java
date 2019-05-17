package com.Lesson3.HW.dao.repository;

import com.Lesson3.HW.exeptions.InternalExeption;
import com.Lesson3.HW.model.Storage;
import org.springframework.stereotype.Repository;

@Repository
@javax.transaction.Transactional
public class StorageDAOimpl extends GeneralDAOImpl<Storage> {

    public StorageDAOimpl() {
        setClass(Storage.class);
    }

    public Storage saveStorage(Storage storage) throws InternalExeption {
        return save(storage);
    }

    public Storage updateStorage(Storage storage) throws InternalExeption {
        return update(storage);
    }

    public void deleteStorage(Long id) throws InternalExeption {
        delete(id);
    }

    public Storage findStorageById(Long id) throws InternalExeption {
        return findById(id);
    }
}
