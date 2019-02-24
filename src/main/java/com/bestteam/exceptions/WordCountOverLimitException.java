package com.bestteam.exceptions;

@SuppressWarnings("serial")
public class WordCountOverLimitException extends RuntimeException {
    public WordCountOverLimitException(String reason, String id) {
        super("'" + reason + "' Limit Exceeded in Proposal ID: '" + id + "'");
    }
}
