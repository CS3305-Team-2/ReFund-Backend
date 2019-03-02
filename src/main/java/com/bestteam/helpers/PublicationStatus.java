package com.bestteam.helpers;

public enum PublicationStatus {

    PUBLISHED("Published"),
    IN_PRESS("In Press");

    private String content;

    PublicationStatus(String content) {
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
