package com.project.first.entity;

import com.project.first.enums.EnrollmentStatus;
import com.project.first.enums.Status;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Employee {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    private String email;

    private String password;

    @Enumerated(EnumType.STRING)
    private Status status;

    @ManyToOne
    private Company company;

    @OneToOne
    @JoinColumn(name = "user_id")
    private Users user;

    private boolean certified = false;

}
