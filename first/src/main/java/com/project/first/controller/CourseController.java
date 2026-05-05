package com.project.first.controller;

import com.project.first.requestdto.CourseDto;
import com.project.first.requestdto.EmployeeDto;
import com.project.first.service.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/courses")
@RequiredArgsConstructor
public class CourseController {

    private final CourseService courseService;

    @PostMapping("/add/to/company/{id}")
    public String addCourse(@RequestBody CourseDto courseDto, @PathVariable Long id)
    {
        courseService.addCourse(courseDto, id);
        return "Course added successfully";
    }


}
