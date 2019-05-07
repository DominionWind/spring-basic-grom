package com.Lesson3.HW.Utils;

import com.Lesson3.HW.DAO.Repository.FileDAOimpl;
import com.Lesson3.HW.model.File;
import com.Lesson3.HW.model.Storage;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class Util {

    private FileDAOimpl fileDAOimpl;

    @Autowired
    public Util(FileDAOimpl fileDAOimpl) {
        this.fileDAOimpl = fileDAOimpl;
    }

    public boolean checkSize(Storage storage, File file) throws Exception {
        List<File> files = fileDAOimpl.findFilesByStorage(storage);
        Long fileSize = null;
        for (File f : files) {
            fileSize += f.getSize();
        }
        if ((fileSize += file.getSize()) < storage.getStorageSize()) {
            return true;
        }
        throw new Exception("Not enough free space in storage " + storage.getId() + " for file " + file.getId());
    }

    public boolean checkFormatSupported(Storage storage, File file) throws Exception {
        for (String f : storage.getFormatsSupported().split(",")) {
            if (f.equals(file.getFormat())) {
                return true;
            }
        }
        throw new Exception("storage " + storage.getId() + " does not support for file format " + file.getId());
    }

    public boolean checkExist(Storage storage, File file) throws Exception {
        List<File> files = fileDAOimpl.findFilesByStorage(storage);
        for (File f : files) {
            if (f.equals(file)) {
                throw new Exception("file " + file.getId() + " is already in storage " + storage.getId());
            }
        }
        return true;
    }

    public boolean checkTotalSize(Storage storageFrom, Storage storageTo) throws Exception {
        Long storageToSize = null;
        Long storageFromSize = null;
        Long storageToFreeSpace;

        List<File> filesFrom = fileDAOimpl.findFilesByStorage(storageFrom);
        List<File> filesTo = fileDAOimpl.findFilesByStorage(storageTo);

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
        throw new Exception("Not enough free space in storage " + storageTo.getId()
                + " for transferAllFiles from storage " + storageFrom.getId());
    }
}
