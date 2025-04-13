package com.example.exceptions;

public class NoAvailableSpotException extends RuntimeException {
    public NoAvailableSpotException(String message) {
        super(message);
    }
}