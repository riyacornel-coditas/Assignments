package com.project.second.dtos;

import lombok.Data;

@Data
public class WaiterRequest {

    private String first_name;

    private String last_name;

    private String profile_photo;

    private Double salary;

    private String username;

    private String password;

    private Integer branch_id;

    private Integer restaurant_id;
}
