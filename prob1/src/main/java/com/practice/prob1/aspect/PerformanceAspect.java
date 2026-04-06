package com.practice.prob1.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class PerformanceAspect {

    @Around("execution(* service.*.*(..)")
    public Object measureTime(ProceedingJoinPoint point) throws Throwable
    {
        long start = System.currentTimeMillis();

            Object result = point.proceed();

        long end = System.currentTimeMillis();

        System.out.println(point.getSignature().getName() + "executed in "+
                (end - start) + "time");

        return result;
    }
}
