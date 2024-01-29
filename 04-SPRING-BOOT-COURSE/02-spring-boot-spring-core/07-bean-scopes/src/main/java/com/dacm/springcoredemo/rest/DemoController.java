package com.dacm.springcoredemo.rest;

import com.dacm.springcoredemo.common.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    private Coach myCoach; // define a private field for the dependency
    private Coach anotherCoach;

    public DemoController(@Qualifier(value = "cricketCoach") Coach myCoach,
                          @Qualifier(value = "soccerCoach") Coach anotherCoach) {
        System.out.println("In constrcutor: " + getClass().getSimpleName());
        this.myCoach = myCoach;
        this.anotherCoach = anotherCoach;
    }

    @GetMapping("/dailyWorkout")
    public String getDailyWorkout() {
        return myCoach.getDailyWorkout();
    }

    @GetMapping("/check")
    public String check(){
        return "Comparing beans my coach == anotherCoach, " + (myCoach == anotherCoach);
    }
}






