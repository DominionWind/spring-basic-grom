package com.Lesson2.HW2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@org.springframework.stereotype.Controller
public class Controller {
    @Autowired
    ItemService itemService;

    @Autowired
    ItemUtil util;

    @RequestMapping(method = RequestMethod.GET, value = "/testHW2", produces = "text/plain")
    public @ResponseBody String getItem(){
        return itemService.getAllI().toString();
    }

    @RequestMapping(method = RequestMethod.POST, value = "/saveHW2", produces = "application/json")
    public @ResponseBody void doPost(HttpServletRequest request){
        try {
            itemService.saveI(util.mapper(request));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/updateHW2", produces = "application/json")
    public @ResponseBody void doPut(HttpServletRequest request){
        try {
            itemService.updateI(util.mapper(request));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/deleteHW2", produces = "text/plain")
    public @ResponseBody void doDelete(@RequestParam("id")Long id){
        try {
            itemService.deleteI(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
