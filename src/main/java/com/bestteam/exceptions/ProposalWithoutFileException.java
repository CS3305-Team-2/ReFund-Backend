package com.bestteam.exceptions;

@SuppressWarnings("serial")
public class ProposalWithoutFileException extends RuntimeException {
    public ProposalWithoutFileException() {
        super("Proposal submitted as not a draft but no file was sent.");
    }
}
