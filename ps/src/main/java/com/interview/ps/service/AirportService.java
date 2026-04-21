package com.interview.ps.service;

import com.interview.ps.dto.AddAirlines;
import com.interview.ps.dto.AddAirport;
import com.interview.ps.entity.Airline;
import com.interview.ps.entity.Airport;
import com.interview.ps.repository.AirportRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AirportService {

    private final AirportRepository airportRepository;

    @Transactional
    public void addAirport(AddAirport airport) {
        Airport a = new Airport();
        a.setName(airport.getName());
        a.setLocation(airport.getLocation());
        airportRepository.save(a);
    }


    @Transactional
    public List<AddAirport> getAll()
    {
        List<Airport> airports = airportRepository.findAll();

        List<AddAirport> airportList = new ArrayList<>();

        for(Airport airport: airports)
        {
            AddAirport a = new AddAirport();
            a.setName(airport.getName());
            a.setLocation(airport.getLocation());

            airportList.add(a);
        }

        return airportList;
    }
}
