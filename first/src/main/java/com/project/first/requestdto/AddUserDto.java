package com.project.first.requestdto;

import com.project.first.enums.Role;
import lombok.Data;

@Data
public class AddUserDto {
    private String name;

    private String email;

    private String password;

}
