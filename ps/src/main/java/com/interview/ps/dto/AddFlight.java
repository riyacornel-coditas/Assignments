package com.interview.ps.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class AddFlight {

    private String origin;

    private String destination;

    private LocalDate departureDate;

    private Integer totalSeats;
}
