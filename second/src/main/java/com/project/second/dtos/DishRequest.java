package com.project.second.dtos;

import lombok.Data;

@Data
public class DishRequest {

    private String dish_name;

    private String description;

    private String type;

    private Integer price;

    private Integer restaurant_id;
}
