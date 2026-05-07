package com.project.first.requestdto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class AssignmentDto {
    @NotBlank(message = "description required")
    private String description;
}
