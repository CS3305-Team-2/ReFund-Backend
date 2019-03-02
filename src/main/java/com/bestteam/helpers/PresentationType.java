package com.bestteam.helpers;

public enum PresentationType {

    CONFERENCE("Conference"),
    INVITED_SEMINAR("Invited Seminar"),
    KEYNOTE("Keynote");

    private String content;

    PresentationType(String content) {
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
