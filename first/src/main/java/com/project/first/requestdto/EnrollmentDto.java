package com.project.first.requestdto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class EnrollmentDto {

    @NotNull(message = "employee id required")
    private Long employeeId;

    @NotBlank(message = "company name required")
    private String name;

    @NotBlank(message = "course title required")
    private String title;
}
