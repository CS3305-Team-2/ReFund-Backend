package com.bestteam.exceptions;

@SuppressWarnings("serial")
public class EducationAndPublicEngagementNotFoundException extends RuntimeException {
    public EducationAndPublicEngagementNotFoundException(String educationAndPublicEngagementId) {
        super("Education And Public Engagement ID " + educationAndPublicEngagementId + " not found.");
    }
}
