package com.assignment.Week9.controller;

import com.assignment.Week9.dto.UserDto;
import com.assignment.Week9.entity.User;
import com.assignment.Week9.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService service;

    @PostMapping("/add/super-admin")
    public String createSuperAdmin(@RequestBody UserDto dto)
    {
        service.createSuperAdmin(dto);
        return "Super admin created";
    }

    @PostMapping("/add/admin")
    public String createAdmin(@RequestBody UserDto dto)
    {
         service.createAdmin(dto);
         return "admin created";
    }

    @PostMapping("/add/client-admin")
    public String createClientAdmin(@RequestBody UserDto dto)
    {
        service.createClientAdmin(dto);
        return "client admin created";
    }

    @PostMapping("/add/candidate")
    public String createCandidate(@RequestBody UserDto dto)
    {
        service.createCandidate(dto);
        return "candidate created";
    }

}
