package com.Lesson3.HW.DAO;

import com.Lesson3.HW.model.File;
import com.Lesson3.HW.model.Storage;

import java.util.List;

public interface FileDAO extends GeneralDAO<File> {

    File save(Storage storage, File file);
    File update(Storage storage, File file);
    void delete(Storage storage, Long id);
    File findById(Storage storage, Long id);
    File findByName(Storage storage, String name);
    List<File> getFilesByStorageId(Long id);
}
