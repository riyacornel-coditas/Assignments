package com.assignment.Week9.controller;

import com.assignment.Week9.dto.SessionDto;
import com.assignment.Week9.entity.Session;
import com.assignment.Week9.service.SessionService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/session")
@RequiredArgsConstructor
public class SessionController {
    private final SessionService service;

    @PostMapping
    public Session create(@RequestBody SessionDto dto) {
        return service.createSession(dto);
    }
}
