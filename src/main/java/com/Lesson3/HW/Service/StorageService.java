package com.Lesson3.HW.Service;

import com.Lesson3.HW.DAO.StorageRepository;
import com.Lesson3.HW.Utils.Util;
import com.Lesson3.HW.model.File;
import com.Lesson3.HW.model.Storage;
import org.springframework.beans.factory.annotation.Autowired;

public class StorageService {

    private StorageRepository storageRepository;
    private Util util;

    @Autowired
    public StorageService(StorageRepository storageRepository, Util util) {
        this.storageRepository = storageRepository;
        this.util = util;
    }

    public void transferAll(Storage storageFrom, Storage storageTo){
        //размер
        //проверка форматов
        //проверка дубликата файлов
        //


    }


    public void transferFile(Storage storageFrom, Storage storageTo, File file){



    }

}
