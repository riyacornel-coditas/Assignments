package com.interview.ps.controller;

import com.interview.ps.dto.AddAircraft;
import com.interview.ps.dto.AddAirlines;
import com.interview.ps.service.AircraftService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/aircrafts")
@RequiredArgsConstructor
public class AircraftController {

    private final AircraftService aircraftService;

    @PostMapping("/add")
    public String addAircraft(@RequestBody AddAircraft aircraft)
    {
        aircraftService.addAircraft(aircraft);
        return "Aircraft added";
    }

    @GetMapping("/getall")
    public List<AddAircraft> getAll()
    {
        return aircraftService.getAll();
    }


}
