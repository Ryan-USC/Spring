package org.example.exception;

public class MyUserException extends Exception{
    public MyUserException() {
    }

    public MyUserException(String message) {
        super(message);
    }
}
