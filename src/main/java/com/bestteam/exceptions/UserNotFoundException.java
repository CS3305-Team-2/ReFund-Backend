package com.bestteam.exceptions;

@SuppressWarnings("serial")
public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException(String username) {
        super("User ID " + username + " not found.");
    }
}