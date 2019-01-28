package com.bestteam.exceptions;

@SuppressWarnings("serial")
public class EmploymentNotFoundException extends RuntimeException {
    public EmploymentNotFoundException(String employmentId) {
        super("Employment ID " + employmentId + " not found.");
    }
}
