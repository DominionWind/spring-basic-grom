package com.Lesson2.HW1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

public class Controller {
    @Autowired
    Route route;

    @RequestMapping(method = RequestMethod.GET, value = "/testHW1", produces = "text/plain")
    public @ResponseBody
    String callByBean(){
        route.getId();
        route.getSteps();

        System.out.println("OK");
        return route.toString();
    }

}
