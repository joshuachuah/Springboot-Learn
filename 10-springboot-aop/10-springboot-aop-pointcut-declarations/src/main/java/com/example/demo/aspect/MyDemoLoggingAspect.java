package com.example.demo.aspect;

import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.aspectj.lang.annotation.Aspect;

@Aspect
@Component
public class MyDemoLoggingAspect {

    // add all advices for logging

    // pointcut declaration
    @Pointcut("execution(* com.example.demo.dao.*.*(..))")
    public void pointcut() {

    }

    // this is a pointcut expression
    @Before("pointcut()")
    public void beforeAddAccountAdvice() {

        System.out.println("\n=====>>> Executing @Before advice on method");
    }

}
