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


    // pointcut for getter methods
    @Pointcut("execution(* com.example.demo.dao.*.get*(..))")
    private void getter(){

    }


    // pointcut for setter methods
    @Pointcut("execution(* com.example.demo.dao.*.set*(..))")
    private void setter(){

    }


    // create pointcut: include package...exclude getter / setter
    @Pointcut("pointcut() && !(getter() || setter())")
    private void pointcutNoGetterSetter(){

    }

    // this is a pointcut expression
    @Before("pointcutNoGetterSetter()")
    public void beforeAddAccountAdvice() {

        System.out.println("\n=====>>> Executing @Before advice on method");
    }

    @Before("pointcutNoGetterSetter()")
    public void performApiAnalytics() {

        System.out.println("\n=====>>> Performing API Analytics");
    }

}
