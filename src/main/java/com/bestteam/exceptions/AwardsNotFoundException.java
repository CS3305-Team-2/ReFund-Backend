package com.bestteam.exceptions;

@SuppressWarnings("serial")
public class AwardsNotFoundException extends RuntimeException {
    public AwardsNotFoundException(String awardsId) {
        super("Awards ID " + awardsId + " not found.");
    }
}
