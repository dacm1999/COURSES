package com.dacm.springboot.demo.firstAppSpringBoot.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FunRestController {

    //Expose " / " that return "HELLO WORLD "
    @GetMapping("/")
    public String sayHello(){
        return "Hello world";
    }
}
