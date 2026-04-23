package com.assignment.Week9.controller;

import com.assignment.Week9.dto.AuthenticateUser;
import com.assignment.Week9.utility.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private AuthenticationManager authenticationManager;

    @PostMapping("/authenticate")
    public String generateToken(@RequestBody AuthenticateUser authenticateUser)
    {
        try
        {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(authenticateUser.getName(),
                            authenticateUser.getPassword())

            );

            return jwtUtil.generateToken(authenticateUser.getName());
        }
        catch (Exception e)
        {
            throw e;
        }
    }
}
