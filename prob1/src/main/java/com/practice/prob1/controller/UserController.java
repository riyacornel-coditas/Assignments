package com.practice.prob1.controller;

import com.practice.prob1.dto.UserCreate;
import com.practice.prob1.entity.User;
import com.practice.prob1.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/create")
    public User createUser(@RequestBody UserCreate userCreate)
    {
        return userService.createUser(userCreate);
    }

    @PostMapping("/validate")
    public UserCreate validateUser(@RequestBody UserCreate userCreate)
    {
        return userService.login(userCreate);
    }
}
