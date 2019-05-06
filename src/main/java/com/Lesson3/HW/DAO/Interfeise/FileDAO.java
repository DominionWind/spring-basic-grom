package com.Lesson3.HW.DAO.Interfeise;

import com.Lesson3.HW.model.File;
import com.Lesson3.HW.model.Storage;

import java.util.List;

public interface FileDAO extends GeneralDAO<File> {
    File save(Storage storage, File file);
    File delete(Storage storage, File file);
    void transferAll(Storage storageFrom, Storage storageTo);
    File transferFile(Storage storageFrom, Storage storageTo, Long id);
    List<File> findFilesByStorage(Storage storage);
    List<File> getAllFiles();
}
