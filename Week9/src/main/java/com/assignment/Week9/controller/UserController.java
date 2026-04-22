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

    @PostMapping("/add")
    public User create(@RequestBody UserDto dto) {
        return service.createUser(dto);
    }
}
