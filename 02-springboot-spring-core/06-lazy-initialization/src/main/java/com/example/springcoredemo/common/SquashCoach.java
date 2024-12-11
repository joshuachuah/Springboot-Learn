package com.example.springcoredemo.common;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
public class SquashCoach implements Coach{

    public SquashCoach() {
        System.out.println("SquashCoach: " + getClass().getSimpleName());
    }

    @Override
    public String getDailyWorkout(){
        return "Practice straight drives for 30 minutes";
    }
}
