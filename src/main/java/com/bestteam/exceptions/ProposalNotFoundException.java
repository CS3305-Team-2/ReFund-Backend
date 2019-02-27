package com.bestteam.exceptions;

@SuppressWarnings("serial")
public class ProposalNotFoundException extends RuntimeException {
    public ProposalNotFoundException(Long proposalId) {
        super("Proposal ID " + proposalId + " not found.");
    }
}
