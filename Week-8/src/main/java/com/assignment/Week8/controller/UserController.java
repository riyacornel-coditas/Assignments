package com.assignment.Week8.controller;

import com.assignment.Week8.dto.AddUser;
import com.assignment.Week8.entity.Users;
import com.assignment.Week8.service.CustomUserDetailsService;
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

    @PostMapping("/store")
    public Users addUser(@RequestBody AddUser addUser)
    {
        return customUserDetailsService.addUser(addUser);
    }
}
