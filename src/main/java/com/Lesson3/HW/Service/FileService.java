package com.Lesson3.HW.Service;

import com.Lesson3.HW.DAO.FileRepository;
import com.Lesson3.HW.Utils.Util;
import com.Lesson3.HW.model.File;
import com.Lesson3.HW.model.Storage;
import org.springframework.beans.factory.annotation.Autowired;

public class FileService {

    private FileRepository fileRepository;
    private Util util;

    @Autowired
    public FileService(FileRepository fileRepository, Util util) {
        this.fileRepository = fileRepository;
        this.util = util;
    }

    public File put(Storage storage, File file) {
        util.checkFormatSupported(storage, file);
        util.checkSize(storage, file);
        util.checkExist(storage, file);
        file.setStorage(storage);
        return file;
    }

    public void delete(Storage storage, File file) {
        util.checkExist(storage, file);
        fileRepository.delete(storage, file.getId());
    }

}
