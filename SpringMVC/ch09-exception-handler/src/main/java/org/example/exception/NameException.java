package org.example.exception;

public class NameException extends MyUserException{
    public NameException() {
    }

    public NameException(String message) {
        super(message);
    }
}
