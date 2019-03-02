package com.bestteam.helpers;

public enum PublicationType {

    REFEREED_ORIGINAL_ARTICLE("Refereed Original Article"),
    REFEREED_REVIEW_ARTICLE("Refereed Review Article"),
    REFEREED_CONFERENCE_ARTICLE("Refereed Conference Article"),
    BOOK("Book"),
    TECHNICAL_REPORT("Technical Report");

    private String content;

    PublicationType(String content) {
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
