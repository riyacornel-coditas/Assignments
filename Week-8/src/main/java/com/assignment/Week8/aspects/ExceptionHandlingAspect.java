package com.assignment.Week8.aspects;

import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ExceptionHandlingAspect {

    @AfterThrowing(pointcut = "execution(* com.assignment.Week8.service.*.*(..))", throwing = "ex")
    public void handle(Exception ex)
    {
        System.out.println("Exception occurred: "+ ex.getMessage());
    }
}
