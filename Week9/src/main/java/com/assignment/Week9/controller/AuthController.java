package com.assignment.Week9.controller;

import com.assignment.Week9.dto.UserDto;
import com.assignment.Week9.entity.User;
import com.assignment.Week9.repository.UserRepository;
import com.assignment.Week9.utility.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {
    private final UserRepository repo;
    private final JwtUtil jwtUtil;
    private final PasswordEncoder encoder;

    @PostMapping("/login")
    public String login(@RequestBody UserDto dto) {

        User user = repo.findByEmail(dto.getEmail())
                .orElseThrow();

        if (encoder.matches(dto.getPassword(), user.getPassword())) {
            return jwtUtil.generateToken(user.getEmail());
        }

        throw new RuntimeException("Invalid credentials");
    }
}
