package com.project.second.entity;

import com.project.second.enums.Role;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Chef {

    @Id
    @GeneratedValue
    private Integer id;

    private String first_name;

    private String last_name;

    private String profile_photo;

    private Double salary;

    private String cuisine;

    @OneToOne
    @JoinColumn(name = "user_id")
    private Users user;

    @ManyToOne
    @JoinColumn(name = "branch_id")
    private RestaurantBranch branch;

    @ManyToOne
    @JoinColumn(name = "restaurant_id")
    private Restaurant restaurant;


}
