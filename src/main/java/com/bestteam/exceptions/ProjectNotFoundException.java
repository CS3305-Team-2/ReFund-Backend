package com.bestteam.exceptions;

@SuppressWarnings("serial")
public class ProjectNotFoundException extends RuntimeException {
    public ProjectNotFoundException(Long project) {
        super("Project ID " + project + " not found.");
    }
}
