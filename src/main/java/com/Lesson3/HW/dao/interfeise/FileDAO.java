package com.Lesson3.HW.dao.interfeise;

import com.Lesson3.HW.exeptions.InternalExeption;
import com.Lesson3.HW.model.File;
import com.Lesson3.HW.model.Storage;

import java.util.List;

public interface FileDAO extends GeneralDAO<File> {
    File save(Storage storage, File file) throws InternalExeption;
    File delete(Storage storage, File file) throws InternalExeption;
    void transferAll(Storage storageFrom, Storage storageTo) throws InternalExeption;
    File transferFile(Storage storageFrom, Storage storageTo, Long id) throws InternalExeption;
    List<File> findFilesByStorage(Storage storage);
    List<File> getAllFiles();
}
