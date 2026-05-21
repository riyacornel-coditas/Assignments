package com.project.second.dtos;

import lombok.Data;

@Data
public class ChefRequest {

    private String first_name;

    private String last_name;

    private String username;

    private String password;

    private String profile_photo;

    private Double salary;

    private Integer branch_id;

    private Integer restaurant_id;

    private String cuisine;
}
