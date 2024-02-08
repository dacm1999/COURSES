package com.dacm.springboot.thymeleafdemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloWorldController {

    //Need a CONTROLLER METHOD to show initial HTML FORM
    @RequestMapping("/showform")
    public String showForm(){
        return "helloworld-form";
    }

    //NEED A CONTROLLER METHOD TO RPOCESS THE HTML FORM
    @RequestMapping("/processForm")
    public String processForm() {
        return "helloworld";
    }
}
