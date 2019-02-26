package com.bestteam.exceptions;

@SuppressWarnings("serial")
public class ProposalNotDraftException extends RuntimeException {
    public ProposalNotDraftException(String proposalId) {
        super("Proposal ID " + proposalId + " is not a draft and so cannot be edited.");
    }
}
