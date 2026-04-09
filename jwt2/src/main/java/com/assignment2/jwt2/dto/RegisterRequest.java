package com.assignment2.jwt2.dto;

import com.assignment2.jwt2.enums.Role;
import lombok.Data;

@Data
public class RegisterRequest {

    private String username;

    private String password;

    private String email;

    private Role role;
}
