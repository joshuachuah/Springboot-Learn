package com.example.demo.aspect;

import com.example.demo.Account;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.List;

@Aspect
@Component
@Order(3)
public class MyDemoLoggingAspect {

    @AfterThrowing(
            pointcut = "execution(* com.example.demo.dao.AccountDAO.findAccounts(..))",
            throwing ="exception"
    )
    public void afterThrowingFindAccountsAdvice(JoinPoint theJoinPoint, Throwable exception) {

        // print out which method we are advising on
        String method = theJoinPoint.getSignature().toShortString();
        System.out.println("\n========>>> Executing @AfterThrowing on method: " + method);

        // log the exception
        System.out.println("\n========>>> The exception is: " + exception);
    }

    // add new advice for @AfterReturning on the findAccounts method
    @AfterReturning(
            pointcut = "execution(* com.example.demo.dao.AccountDAO.findAccounts(..))",
            returning ="result")
    public void afterReturningFindAccountsAdvice(JoinPoint theJoinPoint, List<Account> result) {

        // print out which method we are advising on
        String method = theJoinPoint.getSignature().toShortString();
        System.out.println("\n========>>> Executing @AfterReturning on method: " + method);

        // print out the results of the method call
        System.out.println("\n========>>> Result is: " + result);

        // post-process data and modify it


        // convert account names to uppsercase
        convertAccountNamesToUpperCase(result);

        System.out.println("\n=======>>> result is: " + result);

    }

    private void convertAccountNamesToUpperCase(List<Account> result) {

        // loop through accounts
        for (Account tempAccount : result) {

            String theUpperName = tempAccount.getName().toUpperCase();

            // update the name on the account
            tempAccount.setName(theUpperName);
        }

    }

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
