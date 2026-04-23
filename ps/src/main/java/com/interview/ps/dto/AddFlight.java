package com.interview.ps.dto;

import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class AddFlight {

    private String origin;

    private String destination;

    private LocalDateTime departureDate;

    private Integer totalSeats;

    private Double price;
}
