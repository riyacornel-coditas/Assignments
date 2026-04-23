package com.interview.ps.service;

import com.interview.ps.dto.AddAirlines;
import com.interview.ps.dto.AddAirport;
import com.interview.ps.entity.Airline;
import com.interview.ps.entity.Airport;
import com.interview.ps.repository.AirlineRepository;
import com.interview.ps.repository.AirportRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AirlineService {

    private final AirlineRepository airlineRepository;
    private final AirportRepository airportRepository;

    @Transactional
    public void addAirlines(Long id, AddAirlines airlines) {

        Airport airport = airportRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("Airport not found"));
        List<Airline> a = new ArrayList<>();
        for(Airline airline: airlines.getAirlines()) {
            Airline airline1 = new Airline();
            airline1.setName(airline.getName());
            airline1.setAirport(airport);

            a.add(airline1);
        }
        airlineRepository.saveAll(a);
    }

    @Transactional
    public AddAirlines getAll()
    {
        List<Airline> airline = airlineRepository.findAll();

        AddAirlines a = new AddAirlines();
        a.setAirlines(airline);

        return a;
    }
}
