package com.project.second.dtos;

import lombok.Data;

@Data
public class FoodItemRequest {

    private String item_name;

    private Integer quantity;

    private Double cost;

    private Integer chef_id;

    private Integer manager_id;

    private Integer restaurant_id;

    private Integer branch_id;
}
