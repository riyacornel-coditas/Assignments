package com.project.second.exception;

public class TableProcessingException extends RuntimeException {
    public TableProcessingException(String message) {
        super(message);
    }
}
