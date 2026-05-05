package com.project.first.requestdto;

import com.project.first.enums.Role;
import lombok.Data;

@Data
public class AddUserDto {
    private String username;

    private String email;

    private String password;

    private Role role;
}
