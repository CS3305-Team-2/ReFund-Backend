package com.bestteam.helpers;

public enum ProposalStatus {
    UNDER_REVIEW("underReview"),
    DRAFT("draft"),
    WITH_THE_RO("withTheRo"),
    APPROVED("approved");
    
    private String content;
    ProposalStatus(String content){
        this.content = content;
    }

    public String getContent(){
        return content;
    }

    @Override
    public String toString(){
        return content;
    }
}
