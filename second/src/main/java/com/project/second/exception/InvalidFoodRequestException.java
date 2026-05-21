package com.project.second.exception;

public class InvalidFoodRequestException extends RuntimeException {
    public InvalidFoodRequestException(String message) {
        super(message);
    }
}
