package com.project.second.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Payment {

    @Id
    @GeneratedValue
    private Integer id;

    private String payment_mode;

    private String payment_details;

    private Double balance;

    private boolean payment_status;

    @OneToOne
    @JoinColumn(name = "order_id")
    private Order order;
}
