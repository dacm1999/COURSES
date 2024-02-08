package com.dacm.springboot.thymeleafdemo.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloWorldController {

    //Need a CONTROLLER METHOD to show initial HTML FORM
    @GetMapping("/showform")
    public String showForm(){
        return "helloworld-form";
    }

    //NEED A CONTROLLER METHOD TO RPOCESS THE HTML FORM
    @RequestMapping("/processForm")
    public String processForm() {
        return "helloworld";
    }

    //ADD A CONTROLLER METHOD TO READ FORM DARA AND ADD DATA TO THE MODEL
    @RequestMapping("/processFormVersionTwo")
    public String lestShoutDude(HttpServletRequest request, Model model){

        //read the requesr paramenter from the html from
        String thename = request.getParameter("studentName");
        //convert the data to all caps
        thename = thename.toUpperCase();
        // create the message
        String result = "Yo! " + thename;
        // add messsage to the model
        model.addAttribute("messageFromModel", result);

        return "helloworld";
    }

    @PostMapping("/processFormVersionThree")
    public String processFormVersionThree(@RequestParam("studentName")String theName, Model model){

        //convert the data to all caps
        theName = theName.toUpperCase();
        // create the message
        String result = "Yo! " + theName;
        // add messsage to the model
        model.addAttribute("messageFromModel", result);

        return "helloworld";
    }

}
