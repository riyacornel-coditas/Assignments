package com.project.first.requestdto;

import lombok.Data;

@Data
public class AuthenticateUser {

    private String name;
    private String password;
}
