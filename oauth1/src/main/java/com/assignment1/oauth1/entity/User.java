package com.assignment1.oauth1.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Entity
@Data
@Builder
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue
    private Long id;

    private String username;

    private String email;
}
