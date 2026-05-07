package com.project.first.requestdto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.Duration;
import java.time.LocalDate;

@Data
public class CourseDto {

    @NotBlank(message = "title required")
    private String title;

    @NotNull(message = "duration required")
    private Long duration;

    @NotNull(message = "start date required")
    private LocalDate startDate;

    @NotNull(message = "end date required")
    private LocalDate endDate;

}
