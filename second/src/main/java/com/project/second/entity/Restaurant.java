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
public class Restaurant {

    @Id
    @GeneratedValue
    private Integer id;

    private String name;

    private String location;

    private String type;

    private Double revenue;

    private Integer registration_no;

    @OneToMany(mappedBy = "restaurant")
    private List<Order> orders;

    @ManyToMany
    @JoinTable(
            name = "restaurant_owners",
            joinColumns = @JoinColumn(name = "restaurant_id"),
            inverseJoinColumns = @JoinColumn(name = "owner_id")
    )
    private List<Users> owners;

    @OneToMany(mappedBy = "restaurant")
    private List<RestaurantBranch> branches;

    @OneToMany(mappedBy = "restaurant")
    private List<Dish> dishes;

}
