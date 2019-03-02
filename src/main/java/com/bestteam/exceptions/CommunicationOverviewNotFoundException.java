package com.bestteam.exceptions;

@SuppressWarnings("serial")
public class CommunicationOverviewNotFoundException extends RuntimeException {
    public CommunicationOverviewNotFoundException(String communicationOverviewId) {
        super("Communication Overview ID " + communicationOverviewId + " not found.");
    }
}
