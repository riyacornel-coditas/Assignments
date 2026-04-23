package com.interview.ps.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Booking {

    @Id
    @GeneratedValue
    private Long id;

    private String bookingStatus;


    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "userId")
    private Users users;


    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "flightId")
    private Flight flight;


    @OneToOne(mappedBy = "booking", cascade = CascadeType.ALL)
    private Payment payment;

}
