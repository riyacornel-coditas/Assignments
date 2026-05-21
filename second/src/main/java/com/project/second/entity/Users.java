package com.project.second.entity;

import com.project.second.enums.Role;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Users {

    @Id
    @GeneratedValue
    private Integer id;

    private String first_name;

    private String last_name;

    private String username;

    private String password;

    @Enumerated(EnumType.STRING)
    private Role role;

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    private Chef chef;

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    private Waiter waiter;

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    private Manager manager;

    @ManyToMany(mappedBy = "owners")
    private List<Restaurant> restaurant;

}
