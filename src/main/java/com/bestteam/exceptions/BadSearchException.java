package com.bestteam.exceptions;

@SuppressWarnings("serial")
public class BadSearchException extends RuntimeException {
    public BadSearchException(String message) {
        super(message);
    }
}
