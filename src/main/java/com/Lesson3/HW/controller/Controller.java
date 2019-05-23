package com.Lesson3.HW.controller;

import com.Lesson3.HW.Service.FileService;
import com.Lesson3.HW.dao.repository.FileDAOimpl;
import com.Lesson3.HW.model.File;
import com.Lesson3.HW.model.Storage;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;

@org.springframework.stereotype.Controller
public class Controller {

    private FileService fileService;

    @Autowired
    public Controller(FileService fileService){
        this.fileService = fileService;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/hi", produces = "text/plain")
    public @ResponseBody
    String test(){
        return "test";
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
