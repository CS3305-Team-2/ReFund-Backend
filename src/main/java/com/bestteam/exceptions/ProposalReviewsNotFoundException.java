package com.bestteam.exceptions;

@SuppressWarnings("serial")
public class ProposalReviewsNotFoundException extends RuntimeException {
    public ProposalReviewsNotFoundException(String proposalReviewId) {
        super("Proposal Review ID " + proposalReviewId + " not found.");
    }
}
