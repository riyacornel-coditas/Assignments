package com.assignment.Week8.controller;

import com.assignment.Week8.dto.AddUser;
import com.assignment.Week8.dto.AuthenticateUser;
import com.assignment.Week8.util.JWTUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class AuthController {

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    JWTUtil jwtUtil;

    @PostMapping("/authenticate")
    public String generateToken(@RequestBody AuthenticateUser authenticateUser)
    {
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(authenticateUser.getUsername(), authenticateUser.getPassword())
            );

            return jwtUtil.generateToken(authenticateUser.getUsername());
        }

        catch (Exception e)
        {
            throw e;
        }


    }
}
