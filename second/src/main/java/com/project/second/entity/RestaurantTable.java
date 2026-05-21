package com.project.second.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CollectionIdJdbcTypeCode;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class RestaurantTable {

    @Id
    @GeneratedValue
    private Integer id;

    private Integer table_no;

    private String table_type;

    private String status;

    @ManyToOne
    @JoinColumn(name = "branch_id")
    private RestaurantBranch restaurantBranch;

    @ManyToOne
    @JoinColumn(name = "restaurant_id")
    private Restaurant restaurant;

    @OneToOne
    @JoinColumn(name = "chef_id")
    private Chef chef;
}
