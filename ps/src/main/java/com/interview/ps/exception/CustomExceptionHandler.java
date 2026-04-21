package com.interview.ps.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CustomExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<ErrorResponse> handleException(Exception e)
    {
        ErrorResponse r = new ErrorResponse();
        r.setStatus(HttpStatus.BAD_REQUEST.value());
        r.setMessage(e.getMessage());
        r.setTimestamp(System.currentTimeMillis());

        return new ResponseEntity<>(r, HttpStatus.BAD_REQUEST);
    }
}
