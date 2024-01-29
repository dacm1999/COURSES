package com.dacm.springcoredemo.common;

import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
//@Lazy //This annotation is only used if I don't want to use a constructor, but only if I need it.
public class SoccerCoach implements Coach{

    public SoccerCoach() {
        System.out.println("In constructor: " + getClass().getSimpleName());
    }

    @Override
    public String getDailyWorkout() {
        return "I worked out 2 hours";
    }
}
