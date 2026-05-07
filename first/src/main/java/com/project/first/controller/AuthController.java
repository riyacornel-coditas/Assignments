package com.project.first.controller;

import com.project.first.requestdto.AuthenticateUser;
import com.project.first.utility.JWTUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {
    @Autowired
    private JWTUtil jwtUtil;

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
