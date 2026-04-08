package com.assignment1.jwt.controller;

import com.assignment1.jwt.service.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class JwtController {

    private final JwtService jwtService;

    @GetMapping("/generate-token")
    public String generateToken(@RequestParam String username)
    {
        return jwtService.generateToken(username);
    }

}
