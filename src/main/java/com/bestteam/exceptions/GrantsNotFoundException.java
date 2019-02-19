package com.bestteam.exceptions;

@SuppressWarnings("serial")
public class GrantNotFoundException extends RuntimeException {
    public GrantNotFoundException(String grantname) {
        super("Grant ID " + grantname + " not found.");
    }
}
