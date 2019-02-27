package com.bestteam.helpers;

public enum ProposalStatus {
    /*
        State machine
        Draft <--> RO Submitted -|
                                |
         |---  RO Approved <---| ---> Deleted (no status, deleted from DB)
        |---> SFI Approved --|
       |  We can skip the under review part as far as im aware
       Rejected         
    */
    DRAFT("Draft"),
    RO_SUBMITTED("Submitted to RO"),
    RO_APPROVED("RO Approved"),
    SFI_APPROVED("SFI Approved"),
    REJECTED("Rejected");

    private String content;

    ProposalStatus(String content) {
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
