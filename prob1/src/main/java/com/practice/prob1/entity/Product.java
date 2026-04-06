package com.practice.prob1.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class Product {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    private Double price;

    private Integer stock;

    @OneToMany(mappedBy = "product")
    @JsonIgnore
    private List<Order> orders;
}
