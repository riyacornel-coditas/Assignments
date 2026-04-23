package com.interview.ps.entity;

import com.interview.ps.enums.Role;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Users {

    @Id
    @GeneratedValue
    private Long id;

    private String username;

    private String password;

    @Enumerated(EnumType.STRING)
    private Role role;

    @OneToMany(mappedBy = "users", cascade = CascadeType.ALL)
    private List<Booking> booking = new ArrayList<>();

    @OneToOne(mappedBy = "users", cascade = CascadeType.ALL)
    private Payment payment;



}
