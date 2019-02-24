package com.bestteam.exceptions;

@SuppressWarnings("serial")
public class ProposalNotFoundException extends RuntimeException {
    public ProposalNotFoundException(String proposalname) {
        super("Proposal ID " + proposalname + " not found.");
    }
}
