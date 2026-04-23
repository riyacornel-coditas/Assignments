package com.interview.ps.controller;

import com.interview.ps.dto.AddUser;
import com.interview.ps.service.CustomUserDetailsService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final CustomUserDetailsService customUserDetailsService;

    @PostMapping("/create/user")
    public String addUser(@RequestBody AddUser user)
    {
        customUserDetailsService.addUser(user);
        return "User added";
    }

    @PostMapping("/create/admin")
    public String addAdmin(@RequestBody AddUser user)
    {
        customUserDetailsService.addAdmin(user);
        return "Admin added";
    }


}
