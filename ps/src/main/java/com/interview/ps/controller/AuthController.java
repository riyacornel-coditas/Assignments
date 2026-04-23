package com.interview.ps.controller;

import com.interview.ps.dto.AuthenticateUser;
import com.interview.ps.utility.JWTUtil;
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
    private JWTUtil jwtUtil;

    @Autowired
    private AuthenticationManager authenticationManager;

    @PostMapping("/authenticate")
    public String generateToken(@RequestBody AuthenticateUser authenticateUser)
    {
        try
        {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(authenticateUser.getUsername(),
                            authenticateUser.getPassword())

            );

            return jwtUtil.generateToken(authenticateUser.getUsername());
        }
        catch (Exception e)
        {
            throw e;
        }
    }
}
