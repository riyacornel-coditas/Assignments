package com.assignment.Week6.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Positive;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String firstName;
    private String lastName;
    private String department;
    @Column(updatable = false, unique = true)
    private String email;

    @Positive(message="Salary must be positive")
    private Integer salary;

}
