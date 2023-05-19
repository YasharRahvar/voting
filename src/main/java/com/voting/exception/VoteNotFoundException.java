package com.voting.exception;

public class VoteNotFoundException extends RuntimeException{

    private static final long serialVersionID = 1;

    public VoteNotFoundException(String message) {
        super(message);
    }
}
