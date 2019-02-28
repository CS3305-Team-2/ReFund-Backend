package com.bestteam.exceptions;

@SuppressWarnings("serial")
public class HostInstitutionNotFoundException extends RuntimeException {
    public HostInstitutionNotFoundException(String hostInstitution) {
        super("Host Institution ID " + hostInstitution + " not found.");
    }
}
