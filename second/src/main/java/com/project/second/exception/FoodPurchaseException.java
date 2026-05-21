package com.project.second.exception;

public class FoodPurchaseException extends RuntimeException {
    public FoodPurchaseException(String message) {
        super(message);
    }
}
