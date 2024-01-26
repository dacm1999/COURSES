package com.dacm.springboot.demo.firstAppSpringBoot.rest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

@RestController
public class FunRestController {

    @Value("${coach.name}")
    private String coachName;

    @Value("${team.name}")
    private String teamName;

    //Expose new endpoint for "teaminfo
    @GetMapping("/teaminfo")
    public String getTeamInfo(){
        return "Coach: " + coachName + ", Team name:" + teamName;
    }


    //Expose " / " that return "HELLO WORLD "
    @GetMapping("/")
    public String sayHello(){
        return "Hello world";
    }

    // expose a new endpoint for "workouts"
    @GetMapping("/workout")
    public String getDailyWorkout(){
        return "Run hard 5k";
    }


    @GetMapping("/createUsers")
    public String createUsers(){
        return "Today is " + LocalDate.now();
    }


}
