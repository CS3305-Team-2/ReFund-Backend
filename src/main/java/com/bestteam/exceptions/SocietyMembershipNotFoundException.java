package com.bestteam.exceptions;

@SuppressWarnings("serial")
public class SocietyMembershipNotFoundException extends RuntimeException {
    public SocietyMembershipNotFoundException(String societyMembershipId) {
        super("Society Membership ID " + societyMembershipId + " not found.");
    }
}
