package com.interview.ps.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
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

    private LocalDateTime departureDate;

    private Integer totalSeats;

    private Integer bookedSeats=0;

    private Integer remainingSeats;

    private Double price;

    private Double currentPrice;

    @OneToMany(mappedBy = "flight", cascade = CascadeType.ALL)
    private List<Booking> booking = new ArrayList<>();

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "airlineId")
    private Airline airline;


}
