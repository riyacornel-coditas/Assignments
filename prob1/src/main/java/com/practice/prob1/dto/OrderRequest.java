package com.practice.prob1.dto;

import lombok.Data;

@Data
public class OrderRequest {
    private Long userId;
    private Long productId;
    private Integer quantity;
}
