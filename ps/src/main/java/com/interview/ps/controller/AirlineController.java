package com.interview.ps.controller;

import com.interview.ps.dto.AddAirlines;
import com.interview.ps.dto.AddAirport;
import com.interview.ps.service.AirlineService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/airlines")
@RequiredArgsConstructor
public class AirlineController {

    private final AirlineService airlineService;

    @PostMapping("/add/{id}")
    public String addAirlines(@PathVariable Long id, @RequestBody AddAirlines airlines)
    {
        airlineService.addAirlines(id, airlines);
        return "Airlines added";

    }

    @GetMapping("/getall")
    public AddAirlines getAll()
    {
        return airlineService.getAll();
    }
}
