package com.bestteam.exceptions;

@SuppressWarnings("serial")
public class AcademicCollaborationsNotFoundException extends RuntimeException {
    public AcademicCollaborationsNotFoundException(String academicCollaborationsId) {
        super("Academic Collaboration ID " + academicCollaborationsId + " not found.");
    }
}
