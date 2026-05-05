package com.project.first.controller;

import com.project.first.requestdto.AddUserDto;
import com.project.first.service.CustomUserDetailsService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final CustomUserDetailsService customUserDetailsService;

    @PostMapping("/add")
    public String addUser(@RequestBody AddUserDto addUserDto)
    {
        customUserDetailsService.addUser(addUserDto);
        return "User created successfully";
    }

}
