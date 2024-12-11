package com.example.springcoredemo.common;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
public class SquashCoach implements Coach{

    public SquashCoach() {
        System.out.println("SquashCoach: " + getClass().getSimpleName());
    }

    // define init method
    @PostConstruct
    public void doMyStuff(){
        System.out.println("In doMyStuff() : " + getClass().getSimpleName());
    }

    // define destroy method
    @PreDestroy
    public void doRemoveMyStuff(){
        System.out.println("In doRemoveMyStuff() : " + getClass().getSimpleName());
    }

    @Override
    public String getDailyWorkout(){
        return "Practice straight drives for 30 minutes";
    }
}
