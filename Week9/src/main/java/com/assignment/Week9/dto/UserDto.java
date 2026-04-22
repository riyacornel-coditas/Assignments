package com.assignment.Week9.dto;

import com.assignment.Week9.enums.Role;
import lombok.Data;

@Data
public class UserDto {
    private String name;
    private String email;
    private String password;
    private Role role;
}
