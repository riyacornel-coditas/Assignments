package com.assignment2.oauth2.controller;

import com.assignment2.oauth2.entity.RefreshToken;
import com.assignment2.oauth2.service.RefreshTokenService;
import com.assignment2.oauth2.utility.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final RefreshTokenService refreshTokenService;
    private final JwtUtil jwtUtil;

    @PostMapping("/refresh")
    public Map<String,String> refresh(@RequestBody Map<String, String> request)
    {
        String token =request.get("refreshToken");

        RefreshToken rt = refreshTokenService.verify(token);

        String newAccess = jwtUtil.generateToken(rt.getUserId());

        return Map.of(
                "accessToken", newAccess,
                "refreshToken", token
        );
    }

    @PostMapping("/logout")
    public String logout(@RequestBody Map<String, String> req)
    {
        refreshTokenService.delete(req.get("refreshToken"));

        return "Logged out successfully";
    }
}
