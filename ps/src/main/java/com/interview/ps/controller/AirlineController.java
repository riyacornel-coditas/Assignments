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

    @PostMapping("/add/airlines/{id}")
    public String addAirlines( @RequestBody AddAirlines airlines)
    {
        airlineService.addAirlines(airlines);
        return "Airlines added";

    }

    @GetMapping("/getall")
    public List<AddAirlines> getAll()
    {
        return airlineService.getAll();
    }
}
