package com.Lesson3.HW;

import com.Lesson3.HW.controller.Controller;
import com.Lesson3.HW.model.File;
import com.Lesson3.HW.model.Storage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Demo {

    private static Controller controller;

    @Autowired
    private Demo(Controller controller){
        Demo.controller = controller;
    }

    public static void main(String[] args) throws Exception {

        Storage storageFrom = new Storage();
        storageFrom.setId(999);
        storageFrom.setFormatsSupported("txt");
        storageFrom.setStorageCountry("UA");
        storageFrom.setStorageSize(100500);

        Storage storageTo = new Storage();
        storageTo.setId(100);
        storageTo.setFormatsSupported("txt");
        storageTo.setStorageCountry("UA");
        storageTo.setStorageSize(100500);


        File file = new File();
        file.setId(777);
        file.setStorage(storageFrom);
        file.setFormat("txt");
        file.setName("test");
        file.setSize(5);

        controller.delete(storageTo, file);
    }
}
