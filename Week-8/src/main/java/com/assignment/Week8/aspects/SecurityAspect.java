package com.assignment.Week8.aspects;

import com.assignment.Week8.dto.UpdatePriority;
import com.assignment.Week8.repository.TaskRepository;
import lombok.RequiredArgsConstructor;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
@RequiredArgsConstructor
public class SecurityAspect {
    private final TaskRepository taskRepository;

//    @Before("execution (* com.assignment.Week8.service.TaskService.createTask(..))")
//    public void checkManager(JoinPoint joinPoint)
//    {
//        Object[] args = joinPoint.getArgs();
//
//        String role =(String) args[6];
//
//        if(!"manager".equals(role))
//        {
//            throw new RuntimeException("Access Denied");
//        }
//
//        System.out.println("Security check passed");
//    }

    @Before("execution (* com.assignment.Week8.service.TaskService.deleteTask(..))")
    public void checkManager2(JoinPoint joinPoint)
    {
        Object[] args = joinPoint.getArgs();

        Long id =(Long) args[0];

        var employee = taskRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("Employee not found"));

        if(!"manager".equals(employee.getRole()))
        {
            throw new RuntimeException("Access Denied");
        }

        System.out.println("Security check passed");
    }

    @Before("execution (* com.assignment.Week8.service.TaskService.updatePriority(..))")
    public void checkManager3(JoinPoint joinPoint)
    {
        Object[] args = joinPoint.getArgs();

        UpdatePriority task = (UpdatePriority) args[0];

        Long id = task.getId();

        var employee = taskRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("Employee not found"));

        if(!"manager".equals(employee.getRole()))
        {
            throw new RuntimeException("Access Denied");
        }

        System.out.println("Security check passed");
    }
}
