package com.project.first.requestdto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class AssignCourseDto {

    @NotBlank(message = "course title is required")
    private String title;

    @NotBlank(message = "company name is required")
    private String name;
}
