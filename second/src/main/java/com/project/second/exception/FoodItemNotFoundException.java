package com.project.second.exception;

public class FoodItemNotFoundException extends RuntimeException {
    public FoodItemNotFoundException(String message) {
        super(message);
    }
}
