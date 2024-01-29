package com.dacm.springcoredemo.rest;

import com.dacm.springcoredemo.common.Coach;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    private Coach myCoach; // define a private field for the dependency

    public DemoController(@Qualifier(value = "cricketCoach") Coach myCoach) {
        System.out.println("In constrcutor: " + getClass().getSimpleName());
        this.myCoach = myCoach;
    }

    //Define our init method
    @PostConstruct
    public void doMyStartupStuff(){
        System.out.println("In doMyStartuoStuff" + getClass().getSimpleName());
    }

    //Define our destroy method
    @PreDestroy
    public void doMyCleanUptuff(){
        System.out.println("In domyCleanUpStuff" + getClass().getSimpleName());
    }

    @GetMapping("/dailyWorkout")
    public String getDailyWorkout() {
        return myCoach.getDailyWorkout();
    }

}






