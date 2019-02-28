package com.bestteam.exceptions;

@SuppressWarnings("serial")
public class NoJWTFound extends RuntimeException {
    public NoJWTFound() {
        super("No JWT Token found");
    }
}