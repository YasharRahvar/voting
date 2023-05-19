package com.voting.exception;

public class PlayPackageNotFoundException extends RuntimeException{

    private static final long serialVersionID = 1;

    public PlayPackageNotFoundException(String message) {
        super(message);
    }
}
