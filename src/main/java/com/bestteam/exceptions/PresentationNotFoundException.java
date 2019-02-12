package com.bestteam.exceptions;

@SuppressWarnings("serial")
public class PresentationNotFoundException extends RuntimeException {
    public PresentationNotFoundException(String presentation) {
        super("Presentation ID " + presentation + " not found.");
    }
}
