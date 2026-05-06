package com.project.first.requestdto;

import com.project.first.entity.Company;
import com.project.first.entity.Employee;
import com.project.first.enums.Status;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Data;

import java.util.List;

@Data
public class EmployeeDto {


    private String name;

    private String email;

    private String password;

    @Enumerated(EnumType.STRING)
    private Status status;

    private Company companyName;

    private boolean certified;


}
