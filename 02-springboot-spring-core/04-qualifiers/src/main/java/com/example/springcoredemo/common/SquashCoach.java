package com.example.springcoredemo.common;

import org.springframework.stereotype.Component;

@Component
public class SquashCoach implements Coach{

    @Override
    public String getDailyWorkout(){
        return "Practice straight drives for 30 minutes";
    }
}
