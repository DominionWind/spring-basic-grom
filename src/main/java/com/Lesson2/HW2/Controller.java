package com.Lesson2.HW2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

public class Controller {
    @Autowired
    ItemServiceImpl itemService;
    util util = new util();

    @RequestMapping(method = RequestMethod.GET, value = "/testHW2", produces = "text/plain")
    public @ResponseBody
    String getItem(){
        return itemService.getAll().toString();
    }

    @RequestMapping(method = RequestMethod.POST, value = "/saveHW2", produces = "application/json")
    public @ResponseBody void doPost(HttpServletRequest req){
        try {
            itemService.addItem(util.mapper(req));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/updateHW2", produces = "application/json")
    public @ResponseBody void doPut(HttpServletRequest req){
        try {
            itemService.addItem(util.mapper(req));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/deleteHW2", produces = "text/plain")
    public @ResponseBody void doDelete(HttpServletRequest req){
        try {
            itemService.delete(Long.valueOf(req.getParameter("itemId")));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
