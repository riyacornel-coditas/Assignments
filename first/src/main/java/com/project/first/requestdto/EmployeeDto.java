package com.project.first.requestdto;

import com.project.first.entity.Company;
import com.project.first.entity.Employee;
import com.project.first.enums.Status;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.List;

@Data
public class EmployeeDto {

    @NotBlank(message = "name required")
    private String name;

    @Email(message = "invalid email")
    private String email;

    @NotBlank(message = "password required")
    private String password;

    @NotNull(message = "status required")
    @Enumerated(EnumType.STRING)
    private Status status;

    private String companyName;

    private boolean certified;


}
