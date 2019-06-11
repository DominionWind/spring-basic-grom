package com;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.MapType;
import com.fasterxml.jackson.databind.util.JSONPObject;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.model.File;
import com.model.Storage;
import org.json.JSONException;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;


public class Utils {

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

//    public Object mapper(HttpServletRequest request) throws Exception {
//
//        StringBuilder sb = new StringBuilder();
//        try (BufferedReader reader = request.getReader()) {
//            String line;
//            while ((line = reader.readLine()) != null) {
//                sb.append(line).append('\n');
//            }
//        }
//        String string = sb.toString();
//
//        Gson g = new Gson();
//        File file = g.fromJson(string, File.class);
//        Storage storage = g.fromJson(string, Storage.class);
//    }

    public File fileMapper(HttpServletRequest req) throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        Gson g = new Gson();
        return g.fromJson(mapperObject(req), File.class);
    }

    public Storage storageMapper(HttpServletRequest req) throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        Gson g = new Gson();
        return g.fromJson(mapperObject(req), Storage.class);
    }

//    public Object map(HttpServletRequest req) throws Exception{
//        List<JSONPObject> jsonpObjects = new ArrayList<>();
//        String jsonString = mapperObject(req);
//        while ()

//
//
//        ObjectMapper mapper = new ObjectMapper();
//        MapType type = mapper.getTypeFactory().constructMapType(
//                Map.class, String.class, Object.class);
//        Map<String, Object> data = mapper.readValue(mapperObject(req), type);
//        return data;
}


//    Gson g = new Gson();
//    Type type = new TypeToken<Map<String, Seanse>>(){}.getType();
//    Map<String, Seanse> myMap = g.fromJson(json, type);


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
