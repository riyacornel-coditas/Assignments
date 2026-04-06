package com.practice.prob1.aspect;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoginAspect {

    @AfterReturning("execution(* service.UserService.login(..))")
    public void successLogin()
    {
        System.out.println("Login successful");
    }

    @AfterThrowing(pointcut = "execution(* service.UserService.login(..))",
            throwing= "ex")
    public void failure(Exception ex)
    {
        System.out.println("Failed to login: "+ ex.getMessage());
    }
}
