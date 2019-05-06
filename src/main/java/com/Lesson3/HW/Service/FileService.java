package com.Lesson3.HW.Service;

import com.Lesson3.HW.DAO.Repository.FileDAOimpl;
import com.Lesson3.HW.Utils.Util;
import com.Lesson3.HW.model.File;
import com.Lesson3.HW.model.Storage;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class FileService {

    private FileDAOimpl fileDAOimpl;
    private Util util;

    @Autowired
    public FileService(FileDAOimpl fileDAOimpl, Util util) {
        this.fileDAOimpl = fileDAOimpl;
        this.util = util;
    }

    public File put(Storage storage, File file) throws Exception{
        util.checkFormatSupported(storage, file);
        util.checkSize(storage, file);
        util.checkExist(storage, file);
        file.setStorage(storage);
        return file;
    }

    public void delete(Storage storage, File file) throws Exception{
        util.checkExist(storage, file);
        fileDAOimpl.delete(storage, file);
    }

    public void transferAll(Storage storageFrom, Storage storageTo) {
        fileDAOimpl.transferAll(storageFrom, storageTo);
    }

    public File transferFile(Storage storageFrom, Storage storageTo, Long id) throws Exception{
        util.checkFormatSupported(storageFrom, fileDAOimpl.findById(id));
        util.checkSize(storageTo, fileDAOimpl.findById(id));
        util.checkExist(storageFrom, fileDAOimpl.findById(id));
        util.checkExist(storageTo, fileDAOimpl.findById(id));
        return fileDAOimpl.transferFile(storageFrom, storageTo, id);
    }

    public List<File> getAllFiles(){
        return fileDAOimpl.getAllFiles();
    }

}
