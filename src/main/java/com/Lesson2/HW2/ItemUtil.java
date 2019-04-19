package com.Lesson2.HW2;

import com.fasterxml.jackson.databind.ObjectMapper;
import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.io.IOException;

public class ItemUtil {

    public Item mapper(HttpServletRequest req)throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader reader = req.getReader();
        try {
            String line;
            while ((line = reader.readLine()) != null) {
                sb.append(line).append('\n');
            }
        } finally {
            reader.close();
        }
        String data = sb.toString();

        ObjectMapper mapper = new ObjectMapper();
        Item item = mapper.readValue(data, Item.class);
        return item;
    }
}
