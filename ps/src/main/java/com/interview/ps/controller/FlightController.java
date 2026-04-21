package com.interview.ps.controller;

import com.interview.ps.dto.AddAirlines;
import com.interview.ps.dto.AddFlight;
import com.interview.ps.repository.FlightRepository;
import com.interview.ps.service.FlightService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequestMapping("/flights")
@RequiredArgsConstructor
public class FlightController {

    private final FlightService flightService;

    @PostMapping("/add")
    public String addFlight(@RequestBody AddFlight flight)
    {
        flightService.addFlights(flight);
        return "Flight created";
    }

    @PostMapping("/get/byorigin")
    public AddFlight getOrigin(@RequestParam String origin)
    {
        return flightService.findByOrigin(origin);
    }

    @PostMapping("/get/bydestination")
    public AddFlight getDestination(@RequestParam String destination)
    {
        return flightService.findByDestination(destination);
    }

    @PostMapping("/get/bydate")
    public AddFlight getDate(@RequestParam LocalDate date)
    {
        return flightService.findByDate(date);
    }
}
