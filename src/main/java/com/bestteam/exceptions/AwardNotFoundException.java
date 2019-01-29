package com.bestteam.exceptions;

@SuppressWarnings("serial")
public class AwardNotFoundException extends RuntimeException {
    public AwardNotFoundException(String awardId) {
        super("Award ID " + awardId + " not found.");
    }
}
