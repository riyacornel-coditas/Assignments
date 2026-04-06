package com.practice.prob1.dto;

import lombok.Data;

@Data
public class ProductCreate {

    private String name;

    private Double price;

    private Integer stock;
}
