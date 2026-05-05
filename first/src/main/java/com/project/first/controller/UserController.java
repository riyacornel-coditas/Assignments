package com.project.first.controller;

import com.project.first.requestdto.AddUserDto;
import com.project.first.service.CustomUserDetailsService;
import com.project.first.service.DashboardService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final CustomUserDetailsService customUserDetailsService;
    private final DashboardService dashboardService;

    @PostMapping("/add/admin")
    public String addAdmin(@RequestBody AddUserDto addUserDto)
    {
        customUserDetailsService.addAdmin(addUserDto);
        return "Admin created successfully";
    }

    @GetMapping("/view/dashboard/{name}")
    public Map<String, Long> view(@PathVariable String name)
    {
        return dashboardService.getDashboard(name);
    }

}
