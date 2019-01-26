package com.bestteam.exceptions;

import com.bestteam.helpers.Error;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

/**
 * ResponseExceptionHandler
 */
@ControllerAdvice
@RestController
public class ResponseExceptionHandler {
    @ExceptionHandler(UserNotFoundException.class)
    public final ResponseEntity<Error> userNotFound(UserNotFoundException e) {
        Error error = new Error(e.getMessage());
        return new ResponseEntity<Error>(error, HttpStatus.NOT_FOUND);
    }
}