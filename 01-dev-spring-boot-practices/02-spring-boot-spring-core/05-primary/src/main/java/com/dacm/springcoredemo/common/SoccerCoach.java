package com.dacm.springcoredemo.common;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class SoccerCoach implements Coach{

    @Override
    public String getDailyWorkout() {
        return "I worked out 2 hours";
    }
}
