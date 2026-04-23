package com.interview.ps.service;

import com.interview.ps.dto.AddAirport;
import com.interview.ps.dto.AddFlight;
import com.interview.ps.entity.Airport;
import com.interview.ps.entity.Flight;
import com.interview.ps.repository.FlightRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class FlightService {

    private final FlightRepository flightRepository;

    @Transactional
    public void addFlights(AddFlight flight) {

        Flight f = new Flight();
        f.setOrigin(flight.getOrigin());
        f.setDestination(flight.getDestination());
        f.setDepartureDate(flight.getDepartureDate());
        f.setTotalSeats(flight.getTotalSeats());
        f.setPrice(flight.getPrice());

        flightRepository.save(f);
    }

    @Transactional
    public AddFlight findByOrigin(String origin) {
        Flight f = flightRepository.findByOrigin(origin);

        AddFlight addFlight = new AddFlight();
        addFlight.setOrigin(f.getOrigin());
        addFlight.setDestination(f.getDestination());
        addFlight.setDepartureDate(f.getDepartureDate());
        addFlight.setTotalSeats(f.getTotalSeats());
        addFlight.setPrice(f.getPrice());

        return addFlight;
    }

    @Transactional
    public AddFlight findByDestination(String destination) {
        Flight f = flightRepository.findByDestination(destination);

        AddFlight addFlight = new AddFlight();
        addFlight.setOrigin(f.getOrigin());
        addFlight.setDestination(f.getDestination());
        addFlight.setDepartureDate(f.getDepartureDate());
        addFlight.setTotalSeats(f.getTotalSeats());
        addFlight.setPrice(f.getPrice());

        return addFlight;
    }

    @Transactional
    public AddFlight findByDate(LocalDateTime date) {

        Flight f = flightRepository.findByDepartureDate(date);

        AddFlight addFlight = new AddFlight();
        addFlight.setOrigin(f.getOrigin());
        addFlight.setDestination(f.getDestination());
        addFlight.setDepartureDate(f.getDepartureDate());
        addFlight.setTotalSeats(f.getTotalSeats());
        addFlight.setPrice(f.getPrice());

        return addFlight;
    }

    public Page<Flight> getAll() {

        Pageable pageable = PageRequest.of(0,10);

            return flightRepository.findAll(pageable);

    }
}
