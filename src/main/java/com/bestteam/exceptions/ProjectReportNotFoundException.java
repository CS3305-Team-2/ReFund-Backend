package com.bestteam.exceptions;

@SuppressWarnings("serial")
public class ProjectReportNotFoundException extends RuntimeException {
    public ProjectReportNotFoundException(String projectReport) {
        super("Project Report ID " + projectReport + " not found.");
    }
}
