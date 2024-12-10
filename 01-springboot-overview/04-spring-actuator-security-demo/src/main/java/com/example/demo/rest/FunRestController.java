package com.example.demo.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FunRestController {

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

    @GetMapping("/sex")
    public String sex() {
        return "Male";
    }

    @GetMapping("/test")
    public String test() {
        return "Test";
    }

}
