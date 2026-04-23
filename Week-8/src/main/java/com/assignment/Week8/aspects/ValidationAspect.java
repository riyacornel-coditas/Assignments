package com.assignment.Week8.aspects;

import com.assignment.Week8.dto.TaskCreate;
import com.assignment.Week8.dto.UpdatePriority;
import com.assignment.Week8.dto.UpdateStatus;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.scheduling.config.Task;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ValidationAspect {

    @Before("execution(* com.assignment.Week8.service.TaskService.createTask(..))")
    public void check1(JoinPoint joinPoint)
    {
        Object[] args = joinPoint.getArgs();
        TaskCreate task = (TaskCreate) args[0];

        String employeeEmail = task.getEmployeeEmail();

        if(!employeeEmail.contains("@"))
        {
            throw new RuntimeException("Email is invalid");
        }
    }

    @Before("execution(* com.assignment.Week8.service.TaskService.createTask.updatePriority(..))")
    public void check2(JoinPoint joinPoint)
    {
        Object[] args = joinPoint.getArgs();
        UpdatePriority task = (UpdatePriority) args[0];

        String priority = task.getPriority().toString();

        if(!priority.contains("LOW") && !priority.contains("MEDIUM") && !priority.contains("HIGH"))
        {
            throw new RuntimeException("Priority is invalid");
        }
    }

    @Before("execution(* com.assignment.Week8.service.TaskService.updateStatus(..))")
    public void check3(JoinPoint joinPoint)
    {
        Object[] args = joinPoint.getArgs();
        UpdateStatus task = (UpdateStatus) args[0];

        String status = task.getStatus().toString();

        if(!status.contains("ASSIGNED") && !status.contains("IN_PROGRESS") && !status.contains("COMPLETED"))
        {
            throw new RuntimeException("Status is invalid");
        }
    }

//    {
//        "employeeName":"Diya",
//            "employeeEmail": "diya@example.com",
//            "taskTitle": "Testing",
//            "priority": "MEDIUM",
//            "taskDescription": "Testing must be done manually",
//            "status": "COMPLETED",
//            "role":"manager"
//    }


}
