package com.assignment1.oauth1.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class HomeController {

    @GetMapping("/")
    public String home()
    {
        return "Welcome to oauth2 authorization";
    }

    @GetMapping("/home")
    public Map<String, Object> user(@AuthenticationPrincipal OAuth2User oAuth2User)
    {
        return oAuth2User.getAttributes();
    }

    @GetMapping("/login")
    public String login()
    {
        return "Please login using google";
    }
}
