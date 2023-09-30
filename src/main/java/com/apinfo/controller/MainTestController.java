package com.apinfo.controller;

import com.apinfo.automation.Constant;
import com.apinfo.automation.SeleniumComponent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainTestController {

    @Autowired
    private SeleniumComponent seleniumComponent;
    @RequestMapping(value="/doit",method = RequestMethod.GET)
    public String doit(){
        System.out.println("in the MainTestController");
//        seleniumComponent.onlyLog();
//        seleniumComponent.performSeleniumOperations();
        Constant.init();
        seleniumComponent.filghtStatus();//.doit();
        return "Hello User ";
    }

    @RequestMapping(value="/google",method = RequestMethod.GET)
    public String google(){
        System.out.println("in the MainTestController");
        seleniumComponent.google();
        return "G o o g l e !";
    }

}
