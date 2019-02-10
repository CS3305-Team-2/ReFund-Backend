package com.bestteam.exceptions;

@SuppressWarnings("serial")
public class LoginException extends RuntimeException {
    public LoginException(String message) {
        super("Login failed: " + message);
    }
}