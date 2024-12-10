package com.example.demo.rest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FunRestController {

    @Value("${coach.name}")
    private String coachName;

    @Value("${team.name}")
    private String teamName;

    // expose new endpoint for team info

    @GetMapping("/teaminfo")
    public String getTeamInfo() {
        return "Coach: " + coachName + ", Team: " + teamName;
    }
    // expose "/"  prints "hello world!"
    @GetMapping("/")
    public String sayHello  () {
        return "Hello World";
    }

    // expose a new endpoint for "workout"

    @GetMapping("/workout")
    public String workout () {
        return "Run 5k.";
    }

    @GetMapping("/test")
    public String test() {
        return "Test";
    }

}
