package com.assignment1.jwt.service;

import com.assignment1.jwt.util.JwtUtil;
import org.springframework.stereotype.Service;

@Service
public class JwtService {

    public String generateToken(String username)
    {
        String token = JwtUtil.generateToken(username);

        System.out.println("Generated Token" + token);

        return token;
    }
}
