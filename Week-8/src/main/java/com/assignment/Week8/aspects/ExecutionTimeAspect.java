package com.assignment.Week8.aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ExecutionTimeAspect {

    @Around("execution(* com.assignment.Week8.service.*.*(..))")
    public Object measureTime(ProceedingJoinPoint proceedingJoinPoint) throws Throwable
    {
        long start = System.currentTimeMillis();

        Object result = proceedingJoinPoint.proceed();

        long end =System.currentTimeMillis();

        System.out.println(proceedingJoinPoint.getSignature().getName() +
                "executed in "+ (end-start) + "ms");

        return result;
    }
}
