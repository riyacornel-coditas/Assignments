package com.project.first.controller;

import com.project.first.requestdto.AddUserDto;
import com.project.first.service.CustomUserDetailsService;
import com.project.first.service.DashboardService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final CustomUserDetailsService customUserDetailsService;
    private final DashboardService dashboardService;

    @PostMapping
    public String createUser(@Valid @RequestBody AddUserDto addUserDto)
    {
        customUserDetailsService.createUser(addUserDto);
        return "User created successfully";
    }

    @GetMapping("/{companyName}/dashboard")
    public Map<String, Long> getCompanyDashboard(@PathVariable String companyName)
    {
        return dashboardService.getCompanyDashboard(companyName);
    }

}
