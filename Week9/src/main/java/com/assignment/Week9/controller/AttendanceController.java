package com.assignment.Week9.controller;

import com.assignment.Week9.dto.AttendanceDto;
import com.assignment.Week9.service.AttendanceService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/attendance")
@RequiredArgsConstructor
public class AttendanceController {
    private final AttendanceService service;

    @PostMapping("/scan")
    public String scan(@RequestBody AttendanceDto dto) {
        return service.markAttendance(dto.getQrData());
    }
}
