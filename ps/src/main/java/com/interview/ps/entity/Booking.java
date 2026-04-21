package com.interview.ps.entity;

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

    Integer bookedSeats;

    Integer amountPaid;

    @ManyToOne
    @JoinColumn(name = "userId")
    private Users users;


    @ManyToOne
    @JoinColumn(name = "flightId")
    private Flight flight;


    @OneToOne(mappedBy = "booking", cascade = CascadeType.ALL)
    private Payment payment;

}
