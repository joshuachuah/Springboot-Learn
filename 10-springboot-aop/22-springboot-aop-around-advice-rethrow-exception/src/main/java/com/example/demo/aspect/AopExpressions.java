package com.example.demo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class AopExpressions {

    // pointcut declaration
    @Pointcut("execution(* com.example.demo.dao.*.*(..))")
    public void pointcut() {

    }


    // pointcut for getter methods
    @Pointcut("execution(* com.example.demo.dao.*.get*(..))")
    public void getter(){

    }


    // pointcut for setter methods
    @Pointcut("execution(* com.example.demo.dao.*.set*(..))")
    public void setter(){

    }


    // create pointcut: include package...exclude getter / setter
    @Pointcut("pointcut() && !(getter() || setter())")
    public void pointcutNoGetterSetter(){

    }
}
