package com.Lesson3.HW.DAO;

import com.Lesson3.HW.model.File;
import com.Lesson3.HW.model.Storage;

import java.util.List;

public interface StorageDAO extends GeneralDAO<Storage>{

    File save(Storage storage);
    File update(Storage storage);
    void delete(Long id);
    File findById(Long id);
    void transferAll(Storage storageFrom, Storage storageTo, long filesSize);
    void transferFile(Storage storageFrom, Storage storageTo, File file);
}
