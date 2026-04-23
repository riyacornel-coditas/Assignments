package com.assignment.Week9.controller;

import com.assignment.Week9.dto.ConferenceDto;
import com.assignment.Week9.entity.Conference;
import com.assignment.Week9.service.ConferenceService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/conference")
@RequiredArgsConstructor
public class ConferenceController {
    private final ConferenceService service;

    @PostMapping("/create")
    public String create(@RequestBody ConferenceDto dto)
    {
        service.createConference(dto);
        return "conference created successfully";
    }

    @PostMapping("/view")
    public List<Conference> view()
    {
        return service.viewConference();
    }
}
