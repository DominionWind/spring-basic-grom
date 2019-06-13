package com.Lesson3;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.Lesson3.model.File;
import com.Lesson3.model.Storage;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;

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
}

