package com.project.first.controller;

import com.project.first.requestdto.AssignCourseDto;
import com.project.first.requestdto.CourseDto;
import com.project.first.requestdto.EmployeeDto;
import com.project.first.service.CourseService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/courses")
@RequiredArgsConstructor
public class CourseController {

    private final CourseService courseService;

    @PostMapping("/add")
    public String addCourse(@Valid @RequestBody CourseDto courseDto)
    {
        courseService.addCourse(courseDto);
        return "Course added successfully";
    }

    @PostMapping("/assign")
    public String assignCourseToCompany(@Valid @RequestBody AssignCourseDto assignCourseDto)
    {
        courseService.assignCourseToCompany(assignCourseDto);
        return "Course successfully assigned";
    }


}
