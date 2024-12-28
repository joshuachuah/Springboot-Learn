package com.example.demo.aspect;

import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;
import org.aspectj.lang.annotation.Aspect;

@Aspect
@Component
public class MyDemoLoggingAspect {

    // add all advices for logging


    // start with @Before Advice

    // this is a pointcut expression
    @Before("execution(public void addAccount())")
    public void beforeAddAccountAdvice() {

        System.out.println("\n=====>>> Executing @Before advice on addAccount()");
    }
}
