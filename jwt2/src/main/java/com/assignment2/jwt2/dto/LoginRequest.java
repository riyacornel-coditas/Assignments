package com.assignment2.jwt2.dto;

import lombok.Data;

@Data
public class LoginRequest {

    private String username;

    private String password;
}
