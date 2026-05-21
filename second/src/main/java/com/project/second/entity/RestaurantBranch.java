package com.project.second.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class RestaurantBranch {

    @Id
    @GeneratedValue
    private Integer id;

    private String branch_name;

    private String city;

    @ManyToOne
    @JoinColumn(name = "restaurant_id")
    private Restaurant restaurant;

    @OneToMany(mappedBy = "branch")
    private List<Chef> chefs;

    @OneToOne(mappedBy = "branch")
    private Manager manager;

    @OneToMany(mappedBy = "branch")
    private List<Waiter> waiters;



}
