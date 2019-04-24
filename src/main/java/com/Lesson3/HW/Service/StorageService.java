package com.Lesson3.HW.Service;

import com.Lesson3.HW.DAO.FileRepository;
import com.Lesson3.HW.DAO.StorageRepository;
import com.Lesson3.HW.Utils.Util;
import com.Lesson3.HW.model.File;
import com.Lesson3.HW.model.Storage;
import org.springframework.beans.factory.annotation.Autowired;

public class StorageService {

    private StorageRepository storageRepository;
    private FileRepository fileRepository;
    private Util util;

    @Autowired
    public StorageService(StorageRepository storageRepository, Util util, FileRepository fileRepository) {
        this.storageRepository = storageRepository;
        this.fileRepository = fileRepository;
        this.util = util;
    }

    public void transferAll(Storage storageFrom, Storage storageTo) {
        //размер ++
        //проверка форматов ++
        //проверка дубликата файлов
        //
        util.checkTotalSize(storageFrom, storageTo);
        for (File f : fileRepository.findFilesByStorage(storageFrom)) {
            util.checkFormatSupported(storageTo, f);
        }
        for (File f : fileRepository.findFilesByStorage(storageFrom)) {
            util.checkExist(storageTo, f);
        }

        for (File f : fileRepository.findFilesByStorage(storageFrom)) {
            fileRepository.save(storageTo, f);
        }
    }


    public void transferFile(Storage storageFrom, Storage storageTo, File file) {


    }

}
