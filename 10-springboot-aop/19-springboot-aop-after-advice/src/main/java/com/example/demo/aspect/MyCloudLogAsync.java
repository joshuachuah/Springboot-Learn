package com.example.demo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(1)
public class MyCloudLogAsync {

    @Before("com.example.demo.aspect.AopExpressions.pointcutNoGetterSetter()")
    public void logToCloudAsync() {

        System.out.println("\n=====>>> Logging to Cloud in async");
    }
}
