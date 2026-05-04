package com.project.first.controller;

import com.project.first.requestdto.ManagementDto;
import com.project.first.service.DashboardService;
import com.project.first.service.ManagementService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/management")
public class ManagementController {

    private final ManagementService managementService;
    private final DashboardService dashboardService;

    @PostMapping("/create")
    public String createManagement(@RequestBody ManagementDto management)
    {
        managementService.createManagement(management);
        return "Management created successfully";
    }

    @GetMapping("/dashboard")
    public ResponseEntity<?> dashboard()
    {
        return ResponseEntity.ok(dashboardService.getDashboard());
    }

}
