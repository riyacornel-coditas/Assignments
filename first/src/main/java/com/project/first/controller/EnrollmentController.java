package com.project.first.controller;

import com.project.first.requestdto.EnrollmentDto;
import com.project.first.service.EnrollmentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/enrollments")
@RequiredArgsConstructor
public class EnrollmentController {

    private final EnrollmentService enrollmentService;

    @PostMapping("/employees")
    public String enrollEmployeeIntoCourse(@Valid @RequestBody EnrollmentDto enrollmentDto)
    {
        enrollmentService.enrollEmployeeIntoCourse(enrollmentDto);
        return "Employee has been successfully enrolled into the course";

    }


}
