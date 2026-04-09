package com.assignment2.jwt2.controllers;

import com.assignment2.jwt2.dto.LoginRequest;
import com.assignment2.jwt2.dto.RegisterRequest;
import com.assignment2.jwt2.entity.User;
import com.assignment2.jwt2.repository.UserRepository;
import com.assignment2.jwt2.utility.JwtUtil;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;

    private final AuthenticationManager authenticationManager;

    private final JwtUtil jwtUtil;

    @PostMapping("/register")
    public ResponseEntity<?> register(@Valid @RequestBody RegisterRequest request)
    {
        if(userRepository.existsByUsername(request.getUsername()))
        {
            return ResponseEntity.badRequest().body(Map.of("message", "user already exists"));
        }

        User user = new User();
        user.setUsername(request.getUsername());
        user.setPassword(request.getPassword());
        user.setRole(request.getRole());
        user.setEmail(request.getEmail());

        userRepository.save(user);

        return ResponseEntity.ok("user registered successfully");


    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest request)
    {
        try
        {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            request.getUsername(),
                            request.getPassword()
                    )
            );
        } catch (Exception e) {
            return ResponseEntity.status(401).body(Map.of("'message", "invalid login credentials"));
        }

        User user = userRepository.findByUsername(request.getUsername());

        String token = jwtUtil.generateToken(user.getUsername(),user.getRole().name());

        return ResponseEntity.ok(Map.of("token" , token));
    }

}
