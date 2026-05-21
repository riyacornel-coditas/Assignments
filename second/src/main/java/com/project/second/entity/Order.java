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
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue
    private Integer id;

    private Integer table_no;

    private Double total;

    private String waiter;

    private Boolean liquor_ordered;

    private Boolean dissatisfied;

    private String restaurant_type;

    @OneToMany(mappedBy = "order")
    private List<OrderItems> items;

    @OneToOne(mappedBy = "order", cascade = CascadeType.ALL)
    private Payment payment;

    @ManyToOne
    @JoinColumn(name = "restaurant_id")
    private Restaurant restaurant;

    @ManyToOne
    @JoinColumn(name = "branch_id")
    private RestaurantBranch restaurantBranch;

}
