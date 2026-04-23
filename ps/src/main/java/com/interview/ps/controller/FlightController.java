package com.interview.ps.controller;

import com.interview.ps.dto.AddAirlines;
import com.interview.ps.dto.AddFlight;
import com.interview.ps.entity.Flight;
import com.interview.ps.repository.FlightRepository;
import com.interview.ps.service.FlightService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

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

    @GetMapping("/get/by/origin")
    public AddFlight getOrigin(@RequestParam String origin)
    {
        return flightService.findByOrigin(origin);
    }

    @GetMapping("/get/by/destination")
    public AddFlight getDestination(@RequestParam String destination)
    {
        return flightService.findByDestination(destination);
    }

    @GetMapping("/get/by/date")
    public AddFlight getDate(@RequestParam LocalDateTime date)
    {
        return flightService.findByDate(date);
    }

    @GetMapping("/getall")
    public Page<Flight> getFlights()
    {
        return flightService.getAll();
    }
    //how to convert page to list?
}
