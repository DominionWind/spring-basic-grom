package com.Lesson3.HW.Controller;

import com.Lesson3.HW.Service.FileService;
import com.Lesson3.HW.Utils.Util;
import com.Lesson3.HW.model.File;
import com.Lesson3.HW.model.Storage;
import org.springframework.beans.factory.annotation.Autowired;

public class Controller {

    private FileService fileService;
    private Util util;

    @Autowired
    public Controller(FileService fileService, Util util) {
        this.fileService = fileService;
        this.util = util;
    }

    public void put(Storage storage, File file) throws Exception {
        fileService.put(storage, file);
    }

    public void delete(Storage storage, File file) throws Exception {
        fileService.delete(storage, file);
    }

    public void transferAll(Storage storageFrom, Storage storageTo) {
        fileService.transferAll(storageFrom, storageTo);
    }

    public void transferFile(Storage storageFrom, Storage storageTo, Long id) throws Exception {
        fileService.transferFile(storageFrom, storageTo, id);
    }
}
