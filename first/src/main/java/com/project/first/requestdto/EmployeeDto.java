package com.project.first.requestdto;

import com.project.first.entity.Employee;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Data;

import java.util.List;

@Data
public class EmployeeDto {

    List<Employee> employees;

//    private String name;
//
//    private String email;
//
//    private String password;
//
//    @Enumerated(EnumType.STRING)
//    private String status;
//
//    private String companyName;
//
//    private boolean certified;


}
