package com.project.second.dtos;

import lombok.Data;

@Data
public class ManagerRequest {
    private String first_name;

    private String last_name;

    private Integer contact_no;

    private String email;

    private String qualification;

    private String username;

    private String password;

    private Integer branch_id;

    private Integer restaurant_id;
}
