package com.interview.ps.aspects;

import lombok.RequiredArgsConstructor;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Aspect
@Component
@RequiredArgsConstructor
public class ActivityLoggingAspect {

    private final ActivityLogStore logStore;

    @After("execution(* com.assignment.Week8.service.*.*(..))")
    public void logActivity(JoinPoint joinPoint)
    {
        String methodName = joinPoint.getSignature().getName();
        logStore.addLogs(methodName +"executed at"+ LocalDateTime.now());
    }
}
