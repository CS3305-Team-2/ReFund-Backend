package com.bestteam.exceptions;

public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException(String username) {
        super("User ID " + username + " not found.");
    }
}