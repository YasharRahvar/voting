package com.voting.exception;

public class PersonNotFoundException extends RuntimeException{

    private static final long serialVersionID = 1;

    public PersonNotFoundException(String message) {
        super(message);
    }
}
