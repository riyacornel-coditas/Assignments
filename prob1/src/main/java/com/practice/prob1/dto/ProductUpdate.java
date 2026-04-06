package com.practice.prob1.dto;

import lombok.Data;

@Data
public class ProductUpdate {
    private Long id;
    private Integer stock;
    private Double price;
}
