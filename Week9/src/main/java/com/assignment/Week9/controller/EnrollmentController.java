package com.assignment.Week9.controller;

import com.assignment.Week9.dto.EnrollmentDto;
import com.assignment.Week9.entity.Enrollment;
import com.assignment.Week9.service.EnrollmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/enroll")
@RequiredArgsConstructor
public class EnrollmentController {
    private final EnrollmentService service;

    @PostMapping
    public String enroll(@RequestBody EnrollmentDto dto) {
        service.enroll(dto);
        return "the candidate has successfully enrolled for the session";
    }
}
