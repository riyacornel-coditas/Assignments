package com.project.first.requestdto;

import com.project.first.enums.Role;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class AddUserDto {

    @NotBlank(message = "name is required")
    private String name;

    @Email(message = "invalid email")
    private String email;

    @NotBlank(message = "password is required")
    private String password;

    @NotBlank(message = "role is required")
    private String role;

    private String companyName;

    private String companyType;

}
