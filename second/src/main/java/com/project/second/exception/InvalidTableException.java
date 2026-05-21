package com.project.second.exception;

public class InvalidTableException extends RuntimeException {
    public InvalidTableException(String message) {
        super(message);
    }
}
