package org.example.exception;

public class AgeException extends MyUserException{
    public AgeException() {
    }

    public AgeException(String message) {
        super(message);
    }
}
