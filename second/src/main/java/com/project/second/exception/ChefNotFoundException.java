package com.project.second.exception;

public class ChefNotFoundException extends RuntimeException {
    public ChefNotFoundException(String message) {
        super(message);
    }
}
