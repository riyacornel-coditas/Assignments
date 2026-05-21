package com.project.second.dtos;

import lombok.Data;

@Data
public class OrderItemRequest {
    private Integer dish_id;

    private Integer quantity;
}
