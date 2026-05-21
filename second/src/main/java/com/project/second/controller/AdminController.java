package com.project.second.controller;

import com.project.second.service.InviteService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin")
@RequiredArgsConstructor
public class AdminController {
    private final InviteService inviteService;

    @PostMapping("/send-invite")
    public String sendInvite(@RequestParam String email, @RequestParam String restaurantName)
    {
        return inviteService.sendInvite(email, restaurantName);
    }
}
