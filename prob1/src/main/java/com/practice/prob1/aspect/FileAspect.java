package com.practice.prob1.aspect;

import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class FileAspect {

    @AfterThrowing(pointcut = "execution(* service.FileService.uploadFile(..))",
    throwing = "ex")
    public void failure(Exception ex)
    {
        System.out.println("Upload unsuccessful"+ ex.getMessage());
    }
}


