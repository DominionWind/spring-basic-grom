package com.controller;

import com.Service.FileService;
import com.Utils;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.model.File;
import com.model.Response;
import com.model.Storage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.stereotype.Controller;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

@Controller
public class MainController<T> {

    private FileService fileService;
    private Utils utils;

    @Autowired
    public MainController(FileService fileService) {
        this.fileService = fileService;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/getFiles", produces = "text/plain")
    public @ResponseBody
    String getFiles() {
        return fileService.getAllFiles().toString();
    }

    @RequestMapping(method = RequestMethod.POST, value = "/saveFileInStorage", produces = "application/json")
    public @ResponseBody
    void doPostFile(HttpServletRequest request) {
        try {
            System.out.println(mapperObject(request));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/transferAll", produces = "application/json")
    public @ResponseBody
    void doPutStorage(HttpServletRequest request) {
        try {
            fileService.transferAll(utils.storageMapper(request), utils.storageMapper(request));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

//    @RequestMapping(method = RequestMethod.PUT, value = "/transferFile", produces = "application/json")
//    public @ResponseBody
//    void doPut(HttpServletRequest request) {
//        try {
//            fileService.transferFile(utils.storageMapper(request), utils.storageMapper(request), utils.fileMapper(file).getId());
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/deleteHW3", produces = "text/plain")
    public @ResponseBody
    void doDelete(HttpServletRequest req1, HttpServletRequest req2) {
        try {
            fileService.delete(utils.storageMapper(req1), utils.fileMapper(req2));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @RequestMapping(method = RequestMethod.GET, value = "/jsonToString", produces = "text/plain")
    public @ResponseBody
    void testJsonString(HttpServletRequest req) throws Exception {
//        System.out.println(mapperObject(req));
//        System.out.println(response(req));
        System.out.println(fileFromJson(req)+ "!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");

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

    private Map fileFromJson(HttpServletRequest request) throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        String string = mapperObject(request);


        // convert JSON string to Map
        Map<String, String> map = mapper.readValue(string, Map.class);

        // it works
        //Map<String, String> map = mapper.readValue(json, new TypeReference<Map<String, String>>() {});

        System.out.println(map);

        return map;
    }

    private Response response(HttpServletRequest req) throws Exception {
        String json = mapperObject(req);
        return new Gson().fromJson(json, Response.class);
    }
}
