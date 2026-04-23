package com.interview.ps.service;

import com.interview.ps.dto.AddAircraft;
import com.interview.ps.dto.AddAirlines;
import com.interview.ps.entity.Aircraft;
import com.interview.ps.entity.Airline;
import com.interview.ps.repository.AircraftRepository;
import com.interview.ps.repository.AirlineRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AircraftService {

    private final AircraftRepository aircraftRepository;
    private final AirlineRepository airlineRepository;

    public void addAircraft(AddAircraft aircraft) {

        Aircraft a = new Aircraft();
        a.setName(aircraft.getName());
        a.setType(aircraft.getType());
        a.setCapacity(aircraft.getCapacity());

        Airline air = airlineRepository.findById(aircraft.getAirlineId())
                        .orElseThrow(()-> new RuntimeException("Airline not found"));

        a.setAirline(air);

        aircraftRepository.save(a);
    }

    public List<AddAircraft> getAll() {
        List<Aircraft> aircrafts = aircraftRepository.findAll();

        List<AddAircraft> aircraftList = new ArrayList<>();

        for(Aircraft air: aircrafts) {
            AddAircraft a = new AddAircraft();
            a.setName(air.getName());
            a.setType(air.getType());
            a.setCapacity(air.getCapacity());

            aircraftList.add(a);
        }
        return aircraftList;
    }
}
