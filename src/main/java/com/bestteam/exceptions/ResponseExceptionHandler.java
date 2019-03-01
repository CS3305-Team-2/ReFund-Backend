package com.bestteam.exceptions;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;

import com.bestteam.helpers.Error;

import org.hibernate.exception.ConstraintViolationException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

/**
 * ResponseExceptionHandler must have a method defined for each exception
 * that we wish to catch.
 */
@ControllerAdvice
@RestController
public class ResponseExceptionHandler {
    @ExceptionHandler(Exception.class)
    public final ResponseEntity<Error> catchAllHandler(Exception e) {
        String message = e.getMessage() == null ? "Unknown Error" : e.getMessage();
        ArrayList<String> messages = new ArrayList<>();
        for(String split: message.split("\n")) {
            messages.add(split);
        }
        Error error = new Error(messages.toArray(new String[]{}));
        e.printStackTrace();
        return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(ConstraintViolationException.class)
    public final ResponseEntity<Error> constraintViolated(ConstraintViolationException e) {
        Error error;
        if (e.getSQLException() instanceof SQLIntegrityConstraintViolationException) {
            error = new Error(new String[]{"Foreign key violation"});
        } else {
            error = new Error(new String[]{"idk fam. Ask noah. " + e.getMessage()});
            e.printStackTrace();
        }
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(DataIntegrityViolationException.class)
    public final ResponseEntity<Error> constraintViolatedAgain(DataIntegrityViolationException e) {
        Error error = new Error(new String[]{e.getMostSpecificCause().getMessage()});
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ProposalWithoutFileException.class)
    public final ResponseEntity<Error> noFileSentWithProposal(ProposalWithoutFileException e) {
        Error error = new Error(new String[]{e.getMessage()});
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(FileNotFoundException.class)
    public final ResponseEntity<Error> fileNotFound(FileNotFoundException e) {
        Error error = new Error(new String[]{e.getMessage()});
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(BadSearchException.class)
    public final ResponseEntity<Error> badSearch(BadSearchException e) {
        Error error = new Error(new String[]{e.getMessage()});
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(UserNotFoundException.class)
    public final ResponseEntity<Error> userNotFound(UserNotFoundException e) {
        Error error = new Error(new String[]{e.getMessage()});
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public final ResponseEntity<Error> objectNotValid(MethodArgumentNotValidException e) {
        ArrayList<String> errors = new ArrayList<>();
        e.getBindingResult().getFieldErrors().forEach((err) -> errors.add(err.getField() + " " + err.getDefaultMessage()));
        Error error = new Error(errors.toArray(new String[0]));
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(LoginException.class)
    public final ResponseEntity<Error> loginFailed(LoginException e) {
        Error error = new Error(new String[]{e.getMessage()});
        return new ResponseEntity<>(error, HttpStatus.UNAUTHORIZED);
    }
}