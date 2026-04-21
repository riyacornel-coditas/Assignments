package com.interview.ps.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Flight {

    @Id
    @GeneratedValue
    private Long id;

    private String origin;

    private String destination;

    private LocalDate departureDate;

    private Integer totalSeats;

    private Integer bookedSeats;
    //add time



    @OneToMany(mappedBy = "flight", cascade = CascadeType.ALL)
    private List<Booking> booking = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "airlineId")
    private Airline airline;


}
