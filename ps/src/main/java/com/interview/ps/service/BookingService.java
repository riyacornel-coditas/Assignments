package com.interview.ps.service;

import com.interview.ps.dto.AddTotalSeats;
import com.interview.ps.dto.BookFlight;
import com.interview.ps.entity.Booking;
import com.interview.ps.entity.Flight;
import com.interview.ps.entity.Users;
import com.interview.ps.repository.BookingRepository;
import com.interview.ps.repository.FlightRepository;
import com.interview.ps.repository.UserDetailsRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Service
@RequiredArgsConstructor
public class BookingService {

    private final BookingRepository bookingRepository;
    private final FlightRepository flightRepository;
    private final UserDetailsRepository userDetailsRepository;


    @Transactional
    public void bookFlight(@RequestBody BookFlight bookFlight)
    {
        Booking b = new Booking();

        Users user = userDetailsRepository.findById(bookFlight.getUserId())
                .orElseThrow(()->new EntityNotFoundException("User not found"));

        Flight flight = flightRepository.findById(bookFlight.getFlightId())
                .orElseThrow(()->new EntityNotFoundException("Flight not found"));

        b.setUsers(user);
        b.setFlight(flight);

        bookingRepository.save(b);


    }
}
