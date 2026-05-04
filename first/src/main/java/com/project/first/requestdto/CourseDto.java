package com.project.first.requestdto;

import lombok.Data;

import java.time.Duration;
import java.time.LocalDate;

@Data
public class CourseDto {

    private String title;

    private Long duration;

    private LocalDate startDate;

    private LocalDate endDate;

}
