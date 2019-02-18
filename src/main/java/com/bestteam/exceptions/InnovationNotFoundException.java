package com.bestteam.exceptions;

@SuppressWarnings("serial")
public class InnovationNotFoundException extends RuntimeException {
    public InnovationNotFoundException(String innovation) {
        super("Innovation ID " + innovation + " not found.");
    }
}
