package com.project.second.exception;

public class RestaurantBranchNotFoundException extends RuntimeException {
    public RestaurantBranchNotFoundException(String message) {
        super(message);
    }
}
