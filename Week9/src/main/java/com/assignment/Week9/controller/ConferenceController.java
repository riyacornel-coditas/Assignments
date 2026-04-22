package com.assignment.Week9.controller;

import com.assignment.Week9.dto.ConferenceDto;
import com.assignment.Week9.entity.Conference;
import com.assignment.Week9.service.ConferenceService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/conference")
@RequiredArgsConstructor
public class ConferenceController {
    private final ConferenceService service;

    @PostMapping
    public Conference create(@RequestBody ConferenceDto dto) {
        return service.createConference(dto);
    }
}
