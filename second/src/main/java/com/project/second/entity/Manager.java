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
public class Manager {

    @Id
    @GeneratedValue
    private Integer id;

    private String first_name;

    private String last_name;

    private Integer contact_no;

    private String email;

    private String qualification;

    @OneToOne
    @JoinColumn(name = "user_id")
    private Users user;

    @OneToOne
    @JoinColumn(name = "branch_id")
    private RestaurantBranch branch;

    @OneToOne
    @JoinColumn(name = "restaurant_id")
    private Restaurant restaurant;

}
