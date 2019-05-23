//package com.Lesson3.HW;
//
//import com.Lesson3.HW.Service.FileService;
//import com.Lesson3.HW.controller.Controller;
//import com.Lesson3.HW.dao.repository.FileDAOimpl;
//import com.Lesson3.HW.model.File;
//import com.Lesson3.HW.model.Storage;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.ResponseBody;
//
//import javax.servlet.http.HttpServletRequest;
//import java.io.BufferedReader;
//
//@Component
//public class Demo {
//
//    private com.Lesson3.HW.controller.Controller controller;
//    private FileService fileService;
//    private FileDAOimpl fileDAOimpl;
//
//
//    @Autowired
//    private Demo(Controller controller, FileService fileService, FileDAOimpl fileDAOimpl){
//        this.controller = controller;
//        this.fileService = fileService;
//        this.fileDAOimpl = fileDAOimpl;
//    }
//    @RequestMapping(method = RequestMethod.GET, value = "/hi", produces = "text/plain")
//    public @ResponseBody
//    String test(){
//        return "test";
//    }
//
//    @RequestMapping(method = RequestMethod.GET, value = "/getFiles", produces = "text/plain")
//    public @ResponseBody
//    String getFiles() {
//        return fileService.getAllFiles().toString();
//    }
//
//    @RequestMapping(method = RequestMethod.POST, value = "/saveHW3", produces = "application/json")
//    public @ResponseBody
//    void doPost(HttpServletRequest req1, HttpServletRequest req2) {
//        try {
//            fileService.put(storageMapper(req1), fileMapper(req2));
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//
//    @RequestMapping(method = RequestMethod.PUT, value = "/transferAll", produces = "application/json")
//    public @ResponseBody
//    void doPut(HttpServletRequest storageFrom, HttpServletRequest storageTo) {
//        try {
//            fileService.transferAll(storageMapper(storageFrom), storageMapper(storageTo));
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//
//    @RequestMapping(method = RequestMethod.PUT, value = "/transferFile", produces = "application/json")
//    public @ResponseBody
//    void doPut(HttpServletRequest storageFrom, HttpServletRequest storageTo, HttpServletRequest file ) {
//        try {
//            fileService.transferFile(storageMapper(storageFrom), storageMapper(storageTo), fileMapper(file).getId());
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//
//    @RequestMapping(method = RequestMethod.DELETE, value = "/deleteHW3", produces = "text/plain")
//    public @ResponseBody
//    void doDelete(HttpServletRequest req1, HttpServletRequest req2) {
//        try {
//            fileService.delete(storageMapper(req1), fileMapper(req2));
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//
//    private File fileMapper(HttpServletRequest req) throws Exception {
//        ObjectMapper mapper = new ObjectMapper();
//        File file = mapper.readValue(mapperObject(req), File.class);
//        return file;
//    }
//
//    private Storage storageMapper(HttpServletRequest req) throws Exception {
//        ObjectMapper mapper = new ObjectMapper();
//        Storage storage = mapper.readValue(mapperObject(req), Storage.class);
//        return storage;
//    }
//
//    private String mapperObject(HttpServletRequest req) throws Exception {
//        StringBuilder sb = new StringBuilder();
//        BufferedReader reader = req.getReader();
//        try {
//            String line;
//            while ((line = reader.readLine()) != null) {
//                sb.append(line).append('\n');
//            }
//        } finally {
//            reader.close();
//        }
//        String data = sb.toString();
//        return data;
//    }
//
//
//}
