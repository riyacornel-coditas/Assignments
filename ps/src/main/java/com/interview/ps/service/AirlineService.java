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

    @Transactional
    public void addAirlines(AddAirlines airlines) {

        Airline a = new Airline();
        a.setName(airlines.getName());
        airlineRepository.save(a);
    }

    @Transactional
    public List<AddAirlines> getAll()
    {
        List<Airline> airline = airlineRepository.findAll();

        List<AddAirlines> airlinesList = new ArrayList<>();

        for(Airline air: airline)
        {
            AddAirlines a = new AddAirlines();
            a.setName(air.getName());

            airlinesList.add(a);
        }

        return airlinesList;
    }
}
