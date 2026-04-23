package com.interview.ps.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Airport {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    private String location;

    @OneToMany(mappedBy = "airport", cascade=CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Airline> airlines = new ArrayList<>();



}
