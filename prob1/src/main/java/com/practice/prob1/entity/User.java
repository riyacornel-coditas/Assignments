package com.practice.prob1.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
@Table(name="users")
public class User {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    private String role;

    private String password;

    @OneToMany(mappedBy = "user")
    @JsonIgnore
    private List<Order> orders;

}
