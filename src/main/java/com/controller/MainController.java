package com.controller;

import com.Service.FileService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.model.File;
import com.model.Storage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.stereotype.Controller;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;

@Controller
public class MainController {

    private FileService fileService;

    @Autowired
    public MainController(FileService fileService){
        this.fileService = fileService;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/getFiles", produces = "text/plain")
    public @ResponseBody
    String getFiles() {
        return fileService.getAllFiles().toString();
    }

    @RequestMapping(method = RequestMethod.POST, value = "/saveHW3", produces = "application/json")
    public @ResponseBody
    void doPost(HttpServletRequest storage, HttpServletRequest file) {
        try {
            fileService.put(storageMapper(storage), fileMapper(file));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/transferAll", produces = "application/json")
    public @ResponseBody
    void doPut(HttpServletRequest storageFrom, HttpServletRequest storageTo) {
        try {
            fileService.transferAll(storageMapper(storageFrom), storageMapper(storageTo));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/transferFile", produces = "application/json")
    public @ResponseBody
    void doPut(HttpServletRequest storageFrom, HttpServletRequest storageTo, HttpServletRequest file ) {
        try {
            fileService.transferFile(storageMapper(storageFrom), storageMapper(storageTo), fileMapper(file).getId());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/deleteHW3", produces = "text/plain")
    public @ResponseBody
    void doDelete(HttpServletRequest req1, HttpServletRequest req2) {
        try {
            fileService.delete(storageMapper(req1), fileMapper(req2));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private File fileMapper(HttpServletRequest req) throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(mapperObject(req), File.class);
    }

    private Storage storageMapper(HttpServletRequest req) throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(mapperObject(req), Storage.class);
    }

    private String mapperObject(HttpServletRequest req) throws Exception {
        StringBuilder sb = new StringBuilder();
        try (BufferedReader reader = req.getReader()) {
            String line;
            while ((line = reader.readLine()) != null) {
                sb.append(line).append('\n');
            }
        }
        return sb.toString();
    }
}
