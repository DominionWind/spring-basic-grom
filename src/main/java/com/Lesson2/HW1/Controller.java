package com.Lesson2.HW1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

public class Controller {
    @Autowired
    Route route;

    @Autowired
    Service service;

    @Autowired
    Step step;

    @RequestMapping(method = RequestMethod.GET, value = "/hi", produces = "text/plain")
    public @ResponseBody String test(){
        return "test";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/testHW1", produces = "text/plain")
    public @ResponseBody
    String callByBean(){
        route.getId();
        route.getSteps();

        step.getId();
        step.getParamsServiceFrom();
        step.getParamsServiceTo();
        step.getServiceFrom();
        step.getServiceTo();

        service.getId();
        service.getName();
        service.getParamsToCall();

        System.out.println("OK");
        return route.toString();
    }

}
