package com.example.demo.aspect;

import com.example.demo.Account;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.aspectj.lang.annotation.Aspect;

@Aspect
@Component
@Order(3)
public class MyDemoLoggingAspect {




    // this is a pointcut expression
    @Before("com.example.demo.aspect.AopExpressions.pointcutNoGetterSetter()")
    public void beforeAddAccountAdvice(JoinPoint theJoinPoint) {

        System.out.println("\n=====>>> Executing @Before advice on method");

        // display method signature
        MethodSignature methodSignature = (MethodSignature) theJoinPoint.getSignature();

        System.out.println("Method: " + methodSignature);

        // display method arguments

        // get args
        Object[] args = theJoinPoint.getArgs();

        // loop through args
        for (Object arg : args) {
            System.out.println(arg);

            if (arg instanceof Account){

                // downcast and print account specific stuff
                Account theAccount = (Account) arg;

                System.out.println("account name: " + theAccount.getName());
                System.out.println("account level: " + theAccount.getLevel());
            }
        }
    }



}
