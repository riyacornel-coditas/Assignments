package com.practice.prob1.aspect;

import com.practice.prob1.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
@RequiredArgsConstructor
public class SecurityAspect {

    private final UserRepository userRepository;

    @Before("execution (* service.ProductService.updateProduct(..))")
    public void checkAdmin(JoinPoint joinPoint)
    {
        Object[] args = joinPoint.getArgs();

        Long userId = (Long) args[0];

        var user = userRepository.findById(userId)
                .orElseThrow(()->new RuntimeException("User not found"));

        if(!"admin".equals(user.getRole()))
        {
            throw new RuntimeException("Access Denied");
        }

        System.out.println("Security check passed for user "+userId);
    }
}
