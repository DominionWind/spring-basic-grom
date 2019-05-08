package com.Lesson3.HW.Controller;

import com.Lesson3.HW.Service.FileService;
import com.Lesson3.HW.model.File;
import com.Lesson3.HW.model.Storage;
import org.springframework.beans.factory.annotation.Autowired;

public class Controller {

    private FileService fileService;

    @Autowired
    public Controller(FileService fileService) {
        this.fileService = fileService;
    }

    public void put(Storage storage, File file) throws Exception {
        fileService.put(storage, file);
    }

    public void delete(Storage storage, File file) throws Exception {
        fileService.delete(storage, file);
    }

    public void transferAll(Storage storageFrom, Storage storageTo) throws Exception {
        fileService.transferAll(storageFrom, storageTo);
    }

    public void transferFile(Storage storageFrom, Storage storageTo, Long id) throws Exception {
        fileService.transferFile(storageFrom, storageTo, id);
    }
}
