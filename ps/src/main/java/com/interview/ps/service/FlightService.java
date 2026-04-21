package com.interview.ps.service;

import com.interview.ps.dto.AddFlight;
import com.interview.ps.entity.Flight;
import com.interview.ps.repository.FlightRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
@RequiredArgsConstructor
public class FlightService {

    private final FlightRepository flightRepository;

    @Transactional
    public void addFlights(AddFlight flight) {

        Flight f = new Flight();
        f.setOrigin(flight.getOrigin());
        f.setDestination(flight.getOrigin());
        f.setDepartureDate(flight.getDepartureDate());
        f.setTotalSeats(flight.getTotalSeats());

        flightRepository.save(f);
    }

    @Transactional
    public AddFlight findByOrigin(String origin) {
        Flight f = flightRepository.findByOrigin(origin);

        AddFlight addFlight = new AddFlight();
        addFlight.setOrigin(f.getOrigin());
        addFlight.setDestination(f.getDestination());
        addFlight.setDepartureDate(f.getDepartureDate());

        return addFlight;
    }

    @Transactional
    public AddFlight findByDestination(String destination) {
        Flight f = flightRepository.findByDestination(destination);

        AddFlight addFlight = new AddFlight();
        addFlight.setOrigin(f.getOrigin());
        addFlight.setDestination(f.getDestination());
        addFlight.setDepartureDate(f.getDepartureDate());

        return addFlight;
    }

    @Transactional
    public AddFlight findByDate(LocalDate date) {

        Flight f = flightRepository.findByDepartureDate(date);

        AddFlight addFlight = new AddFlight();
        addFlight.setOrigin(f.getOrigin());
        addFlight.setDestination(f.getDestination());
        addFlight.setDepartureDate(f.getDepartureDate());

        return addFlight;
    }
}
