package com.bestteam.exceptions;

@SuppressWarnings("serial")
public class ScoreNotInRangeException extends RuntimeException {
    public ScoreNotInRangeException(String score) {
        super("The score of " + score + " is not between 0 and 100 (inclusive)");
    }
}
