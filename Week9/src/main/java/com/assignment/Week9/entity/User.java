package com.assignment.Week9.entity;

import com.assignment.Week9.enums.Role;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue
    private Long id;

    private String name;
    private String email;
    private String password;

    @Enumerated(EnumType.STRING)
    private Role role;

    @OneToMany(mappedBy = "clientAdmin", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Session> session = new ArrayList<>();

    @OneToMany(mappedBy = "candidate", cascade=CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Enrollment> enrollment = new ArrayList<>();

    @OneToMany(mappedBy = "admin", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Conference> conference = new ArrayList<>();

    @OneToMany(mappedBy = "candidate", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Attendance> attendance = new ArrayList<>();


}
