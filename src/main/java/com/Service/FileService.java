package com.Service;

import com.exeptions.BadRequestException;
import com.dao.repository.FileDAOimpl;
import com.model.File;
import com.model.Storage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FileService {

    private FileDAOimpl fileDAOimpl;
    @Autowired
    public FileService(FileDAOimpl fileDAOimpl) {
        this.fileDAOimpl = fileDAOimpl;
    }

    public File put(Storage storage, File file) throws Exception {
        checkFormatSupported(storage, file);
        checkSize(storage, file);
        checkExist(storage, file);
        file.setStorage(storage);
        fileDAOimpl.save(storage, file);
        return file;
    }

    public void delete(Storage storage, File file) throws Exception {
        checkExist(storage, file);
        fileDAOimpl.delete(storage, file);
    }

    public void transferAll(Storage storageFrom, Storage storageTo) throws Exception{
        checkTotalSize(storageFrom, storageTo);
        for (File f:fileDAOimpl.findFilesByStorage(storageFrom)){
            checkExist(storageTo,f);
            checkFormatSupported(storageTo,f);
        }
        fileDAOimpl.transferAll(storageFrom, storageTo);
    }

    public File transferFile(Storage storageFrom, Storage storageTo, Long id) throws Exception {
        checkFormatSupported(storageFrom, fileDAOimpl.findById(id));
        checkSize(storageTo, fileDAOimpl.findById(id));
        checkExist(storageFrom, fileDAOimpl.findById(id));
        checkExist(storageTo, fileDAOimpl.findById(id));
        return fileDAOimpl.transferFile(storageFrom, storageTo, id);
    }

    public List getAllFiles() {
        return fileDAOimpl.getAllFiles();
    }

    private boolean checkSize(Storage storage, File file) throws BadRequestException {
        List<File> files = fileDAOimpl.findFilesByStorage(storage);
        Long fileSize = null;
        for (File f : files) {
            fileSize += f.getSize();
        }
        if ((fileSize += file.getSize()) < storage.getStorageSize()) {
            return true;
        }
        throw new BadRequestException("Not enough free space in storage " + storage.getId() + " for file " + file.getId());
    }

    private boolean checkFormatSupported(Storage storage, File file) throws BadRequestException {
        for (String f : storage.getFormatsSupported().split(",")) {
            if (f.equals(file.getFormat())) {
                return true;
            }
        }
        throw new BadRequestException("storage " + storage.getId() + " does not support for file format " + file.getId());
    }

    private boolean checkExist(Storage storage, File file) throws BadRequestException {
        List<File> files = fileDAOimpl.findFilesByStorage(storage);
        for (File f : files) {
            if (f.equals(file)) {
                throw new BadRequestException("file " + file.getId() + " is already in storage " + storage.getId());
            }
        }
        return true;
    }

    private boolean checkTotalSize(Storage storageFrom, Storage storageTo) throws BadRequestException {
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
        throw new BadRequestException("Not enough free space in storage " + storageTo.getId()
                + " for transferAllFiles from storage " + storageFrom.getId());
    }

}
