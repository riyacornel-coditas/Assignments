package com.project.second.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Invitation {

    @Id
    @GeneratedValue
    private Integer id;

    private String email;

    private String token;

    private String restaurant_name;

    private boolean accepted;

    private LocalDateTime created_at;
}
