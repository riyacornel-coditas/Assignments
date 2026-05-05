package com.project.first.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/enroll")
@RequiredArgsConstructor
public class EnrollmentController {

    private final EnrollmentService enrollmentService;


}
