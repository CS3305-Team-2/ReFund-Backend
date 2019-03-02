package com.bestteam.exceptions;

@SuppressWarnings("serial")
public class EventNotFoundException extends RuntimeException {
    public EventNotFoundException(String eventId) {
        super("Event ID " + eventId + " not found.");
    }
}
