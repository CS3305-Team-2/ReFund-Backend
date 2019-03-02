package com.bestteam.helpers;

public enum EventType {

    CONFERENCE("Conference"),
    WORKSHOP("Workshop"),
    SEMINAR("Seminar");

    private String content;

    EventType(String content) {
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
