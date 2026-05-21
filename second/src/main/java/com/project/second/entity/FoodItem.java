package com.project.second.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class FoodItem {

    @Id
    @GeneratedValue
    private Integer id;

    private String item_name;

    private Integer quantity;

    private Double cost;

    private String status;

    @ManyToOne
    @JoinColumn(name = "chef_id")
    private Chef chef;

    @ManyToOne
    @JoinColumn(name = "manager_id")
    private Manager manager;

    @ManyToOne
    @JoinColumn(name = "restaurant_id")
    private Restaurant restaurant;

    @ManyToOne
    @JoinColumn(name="branch_id")
    private RestaurantBranch restaurantBranch;
}
