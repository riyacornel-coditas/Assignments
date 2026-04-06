package com.practice.prob1.aspect;

import com.practice.prob1.entity.Payment;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class PaymentAspect {

    @AfterReturning(pointcut = "execution(* service.PaymentService.processPayment(..))",
    returning = "result")
    public void logSuccess(Object result)
    {

        Payment payment = (Payment) result;

        System.out.println("Transaction successful");
        System.out.println(payment.getId());
        System.out.println(payment.getAmount());
    }

    @AfterThrowing(pointcut = "execution(* service.PaymentService.processPayment(..))",
    throwing = "ex")
    public void logFailure(Exception ex)
    {
        System.out.println("Transaction failure");
        System.out.println(ex.getMessage());
    }
}
