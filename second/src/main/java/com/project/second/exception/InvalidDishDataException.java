package com.project.second.exception;

public class InvalidDishDataException extends RuntimeException {
    public InvalidDishDataException(String message) {
        super(message);
    }
}
