package com.bestteam.exceptions;

@SuppressWarnings("serial")
public class NonAcademicCollaborationsNotFoundException extends RuntimeException {
    public NonAcademicCollaborationsNotFoundException(String nonAcademicCollaborationsId) {
        super("Non-Academic Collaboration ID " + nonAcademicCollaborationsId + " not found.");
    }
}
