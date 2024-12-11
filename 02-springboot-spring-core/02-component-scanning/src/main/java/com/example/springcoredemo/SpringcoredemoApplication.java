package com.example.springcoredemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// scans the util package as well as the springcoredemo package
@SpringBootApplication(
        scanBasePackages = {"com.example.springcoredemo",
                "com.example.util"}
)
public class SpringcoredemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringcoredemoApplication.class, args);
    }

}
