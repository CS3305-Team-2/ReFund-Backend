package com.bestteam.helpers;

public enum ActivityType {

    PUBLIC_EVENT("Public event"),
    IN_CLASS_ACTIVITIES("In-class activities"),
    CAREER_EXPERIENCE_PROGRAMME("Career experience programme"),
    OTHER("Other (please specify)");

    private String content;

    ActivityType(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    @Override
    public String toString() {
        return content;
    }
}
