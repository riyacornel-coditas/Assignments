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
@RequestMapping("/enroll")
@RequiredArgsConstructor
public class EnrollmentController {

    private final EnrollmentService enrollmentService;

    @PostMapping("/employee")
    public void enroll(@Valid @RequestBody EnrollmentDto enrollmentDto)
    {
        enrollmentService.enrollIntoCourse(enrollmentDto);

    }


}
