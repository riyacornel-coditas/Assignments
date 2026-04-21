package com.interview.ps.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Payment {

    @Id
    @GeneratedValue
    private Long id;

    private String paymentMode;

    private String paymentStatus;

    @OneToOne
    @JoinColumn(name = "bookingId")
    private Booking booking;
}
