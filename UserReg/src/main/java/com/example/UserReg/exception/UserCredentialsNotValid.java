package com.example.UserReg.exception;

public class UserCredentialsNotValid extends RuntimeException {
    public UserCredentialsNotValid(String message) {
        super(message);
    }
}
