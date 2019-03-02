package com.bestteam.helpers;

public enum TimePercent {

    PERCENT_0_20("0-20"),
    PERCENT_21_40("21-40"),
    PERCENT_41_60("41-60"),
    PERCENT_61_80("61-80"),
    PERCENT_81_100("81-100");

    private String content;

    TimePercent(String content) {
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
