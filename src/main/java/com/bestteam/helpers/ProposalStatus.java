package com.bestteam.helpers;

public enum ProposalStatus {
    UNDER_REVIEW("Under review"),
    DRAFT("Draft"),
    WITH_THE_RO("With the RO"),
    APPROVED("Approved"),
    REJECTED("Rejected");

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
