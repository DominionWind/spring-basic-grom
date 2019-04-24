package com.Lesson3.HW.Utils;

import com.Lesson3.HW.DAO.FileRepository;
import com.Lesson3.HW.model.File;
import com.Lesson3.HW.model.Storage;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class Util {

    private FileRepository fileRepository;

    @Autowired
    public Util(FileRepository fileRepository) {
        this.fileRepository = fileRepository;
    }

    public boolean checkSize(Storage storage, File file) {
        List<File> files = fileRepository.findFilesByStorage(storage);
        Long fileSize = null;
        for (File f : files) {
            fileSize += f.getSize();
        }
        if ((fileSize += file.getSize()) < storage.getStorageSize()) {
            return true;
        }
        return false;
    }

    public boolean checkFormatSupported(Storage storage, File file) {
        for (String f : storage.getFormatsSupported()) {
            if (f.equals(file.getFormat())) {
                return true;
            }
        }
        return false;
    }

    public boolean checkExist(Storage storage, File file) {
        List<File> files = fileRepository.findFilesByStorage(storage);
        for (File f : files) {
            if (f.equals(file)) {
                return false;
            }
        }
        return true;
    }

    public boolean checkTotalSize(Storage storageFrom, Storage storageTo) {
        Long storageToSize = null;
        Long storageFromSize = null;
        Long storageToFreeSpace;

        List<File> filesFrom = fileRepository.findFilesByStorage(storageFrom);
        List<File> filesTo = fileRepository.findFilesByStorage(storageTo);

        for (File f : filesFrom) {
            storageFromSize += f.getSize();
        }

        for (File f : filesTo) {
            storageToSize += f.getSize();
        }

        if (storageFromSize != null && storageToSize != null) {
            storageToFreeSpace = storageTo.getStorageSize() - storageToSize;

            if (storageToFreeSpace >= storageFromSize) {
                return true;
            }
        }
        return false;
    }
}
