package com.luv2code.springboot.cruddemo.rest;

import jakarta.persistence.Entity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class UsersRestController {

    private List<String> usersList;

    @GetMapping("/test")
    public String testRols(){
        return "Test passed";
    }

}
