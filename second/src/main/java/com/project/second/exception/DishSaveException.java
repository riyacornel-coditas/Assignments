package com.project.second.exception;

public class DishSaveException extends RuntimeException {
    public DishSaveException(String message) {
        super(message);
    }
}
