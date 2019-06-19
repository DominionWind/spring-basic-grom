package com.Lesson3.controller;

//import com.Lesson3.Service.FileService;
//import com.Lesson3.Utils;
//import com.Lesson3.model.Response;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.ResponseBody;
//import org.springframework.stereotype.Controller;
//
//import javax.servlet.http.HttpServletRequest;
//import java.io.BufferedReader;
//import java.util.Map;
//
//@Controller
//public class MainController<T> {
//
//    private FileService fileService;
//    private Utils utils;
//
//    @Autowired
//    public MainController(FileService fileService) {
//        this.fileService = fileService;
//    }
//
//    @RequestMapping(method = RequestMethod.GET, value = "/getFiles", produces = "text/plain")
//    public @ResponseBody
//    String getFiles() {
//        return fileService.getAllFiles().toString();
//    }
//
//    @RequestMapping(method = RequestMethod.POST, value = "/saveFileInStorage", produces = "application/json")
//    public @ResponseBody
//    void doPostFile(HttpServletRequest request) {
//        try {
//            System.out.println(mapperObject(request));
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//
//    @RequestMapping(method = RequestMethod.PUT, value = "/transferAll", produces = "application/json")
//    public @ResponseBody
//    void doPutStorage(HttpServletRequest request) {
//        try {
//            fileService.transferAll(utils.storageMapper(request), utils.storageMapper(request));
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//
////    @RequestMapping(method = RequestMethod.PUT, value = "/transferFile", produces = "application/json")
////    public @ResponseBody
////    void doPut(HttpServletRequest request) {
////        try {
////            fileService.transferFile(utils.storageMapper(request), utils.storageMapper(request), utils.fileMapper(file).getId());
////        } catch (Exception e) {
////            e.printStackTrace();
////        }
////    }
//
//    @RequestMapping(method = RequestMethod.DELETE, value = "/deleteHW3", produces = "text/plain")
//    public @ResponseBody
//    void doDelete(HttpServletRequest req1, HttpServletRequest req2) {
//        try {
//            fileService.delete(utils.storageMapper(req1), utils.fileMapper(req2));
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//
//    @RequestMapping(method = RequestMethod.GET, value = "/jsonToString", produces = "text/plain")
//    public @ResponseBody
//    void testJsonString(HttpServletRequest req) throws Exception {
////        System.out.println(mapperObject(req));
////        System.out.println(response(req));
//        System.out.println(stringFromJson(req) + "!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
//        System.out.println(response(req).getFile() + "&&&&&&&&&&&&&&");
//
//    }
//
//    private String mapperObject(HttpServletRequest req) throws Exception {
//        StringBuilder sb = new StringBuilder();
//        try (BufferedReader reader = req.getReader()) {
//            String line;
//            while ((line = reader.readLine()) != null) {
//                sb.append(line).append('\n');
//            }
//        }
//        return sb.toString();
//    }
//
//    private Map stringFromJson(HttpServletRequest request) throws Exception {
//        ObjectMapper mapper = new ObjectMapper();
//        String string = mapperObject(request);
//        Map<String, String> map = mapper.readValue(string, Map.class);
//        return map;
//    }
//
//    private Response response(HttpServletRequest req) throws Exception {
//        String json = mapperObject(req);
//        ObjectMapper objectMapper = new ObjectMapper();
//        Response response;
//        response = objectMapper.readValue(json, Response.class);
//        return response;
//    }
//}
