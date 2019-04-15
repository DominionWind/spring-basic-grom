package com.Lesson2.HW2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

public class Controller {
    @Autowired
    ItemServiceImpl itemService;

    @RequestMapping(method = RequestMethod.GET, value = "/testHW2", produces = "text/plain")
    public @ResponseBody
    String getItem(){
        return itemService.getAll().toString();
    }
}
