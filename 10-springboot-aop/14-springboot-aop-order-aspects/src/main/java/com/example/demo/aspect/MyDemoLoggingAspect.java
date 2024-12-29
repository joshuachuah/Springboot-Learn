package com.example.demo.aspect;

import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.aspectj.lang.annotation.Aspect;

@Aspect
@Component
@Order(3)
public class MyDemoLoggingAspect {




    // this is a pointcut expression
    @Before("com.example.demo.aspect.AopExpressions.pointcutNoGetterSetter()")
    public void beforeAddAccountAdvice() {

        System.out.println("\n=====>>> Executing @Before advice on method");
    }



}
