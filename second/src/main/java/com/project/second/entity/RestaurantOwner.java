package com.project.second.entity;

import com.project.second.enums.Role;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class RestaurantOwner {

    @Id
    @GeneratedValue
    private Integer id;

    private String first_name;

    private String last_name;

    private Integer contact_no;

    private String email;

}
