package com.assignment.Week8.entity;

import com.assignment.Week8.enums.Priority;
import com.assignment.Week8.enums.Status;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Data
public class Tasks {

    @Id
    @GeneratedValue
    private Long id;

    private String employeeName;

    private String employeeEmail;

    private String taskTitle;

    private String taskDescription;

    @Enumerated(EnumType.STRING)
    private Priority priority;

    @Enumerated(EnumType.STRING)
    private Status status;

    private LocalDateTime createdDate;

    private LocalDateTime updatedDate;

    private String role;

}
