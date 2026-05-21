package com.project.second.dtos;

import lombok.Data;

@Data
public class OwnerRegistrationRequest {
    private String token;

    private String ownerFirstName;

    private String ownerLastName;

    private String username;

    private String password;

    private Integer contactNo;

    private String email;

    private String restaurantName;

    private String city;

    private String branchName;

    private Double revenue;

    private String type;

    private Integer registrationNo;
}
