package com.bestteam.exceptions;

@SuppressWarnings("serial")
public class ProposalNotDraftException extends RuntimeException {
    public ProposalNotDraftException(Long proposalId) {
        super("Proposal ID " + proposalId + " is not a draft and so cannot be edited.");
    }
}
