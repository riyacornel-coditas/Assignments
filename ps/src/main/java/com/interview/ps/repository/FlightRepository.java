package com.interview.ps.repository;

import com.interview.ps.entity.Flight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.time.LocalDateTime;

public interface FlightRepository extends JpaRepository<Flight, Long> {


    Flight findByOrigin(String origin);


    Flight findByDestination(String destination);


    Flight findByDepartureDate(LocalDateTime date);


}
