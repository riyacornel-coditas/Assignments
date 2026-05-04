package com.project.first.requestdto;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Data;

@Data
public class EmployeeDto {

    private String name;

    private String email;

    private String password;

    @Enumerated(EnumType.STRING)
    private String status;
}
