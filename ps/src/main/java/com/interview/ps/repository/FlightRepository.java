package com.interview.ps.repository;

import com.interview.ps.entity.Flight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;

public interface FlightRepository extends JpaRepository<Flight, Long> {

    @Query("SELECT f FROM Flight f WHERE f.origin = origin")
    Flight findByOrigin(String origin);

    @Query("SELECT f FROM Flight f WHERE f.destination = destination")
    Flight findByDestination(String destination);


    Flight findByDepartureDate(LocalDate date);
}
