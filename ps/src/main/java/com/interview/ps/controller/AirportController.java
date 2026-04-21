package com.interview.ps.controller;

import com.interview.ps.dto.AddAirlines;
import com.interview.ps.dto.AddAirport;
import com.interview.ps.entity.Airline;
import com.interview.ps.entity.Airport;
import com.interview.ps.service.AirportService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/airports")
@RequiredArgsConstructor
public class AirportController {

    private final AirportService airportService;

    @PostMapping("/add/airport")
    public String addAirport(@RequestBody AddAirport airport)
    {
        airportService.addAirport(airport);
        return "Airport added";
    }

    @GetMapping("/getall")
    public List<AddAirport> getAll()
    {
        return airportService.getAll();
    }


}
