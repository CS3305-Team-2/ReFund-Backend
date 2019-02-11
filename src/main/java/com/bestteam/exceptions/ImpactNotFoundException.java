package com.bestteam.exceptions;

@SuppressWarnings("serial")
public class ImpactNotFoundException extends RuntimeException {
    public ImpactNotFoundException(String impact) {
        super("Impact ID " + impact + " not found.");
    }
}
