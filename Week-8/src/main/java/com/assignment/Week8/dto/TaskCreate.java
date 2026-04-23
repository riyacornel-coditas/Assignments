package com.assignment.Week8.dto;

import com.assignment.Week8.enums.Priority;
import lombok.Data;

@Data
public class TaskCreate {

    private String employeeName;
    private String employeeEmail;
    private String taskTitle;
    private Priority priority;
    private String taskDescription;
    private String status;
    private String role;
}
