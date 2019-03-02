package com.bestteam.helpers;

public enum ProjectTopic {

    SCIENCE("Science"),
    MATH("Math"),
    ENGINEERING("Engineering"),
    TECHNOLOGY("Technology"),
    SPACE_RELATED("Space related"),
    OTHER("Other");

    private String content;

    ProjectTopic(String content) {
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
