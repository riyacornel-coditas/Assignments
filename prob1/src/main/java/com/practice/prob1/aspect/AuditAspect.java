package com.practice.prob1.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AuditAspect {

    @After("execution(* service.*.*(..))")
    public void logAction(JoinPoint jp)
    {
        String methodName = jp.getSignature().getName();

        Object[] args= jp.getArgs();

        System.out.println("Audit Log:");
        System.out.println("Method:"+ methodName);
        System.out.println("Arguments:"+ java.util.Arrays.toString(args));
        System.out.println("Timestamp:"+ System.currentTimeMillis());
    }
}
