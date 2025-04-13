package com.example.exceptions;

class InvalidTicketException extends RuntimeException {
    public InvalidTicketException(String message) {
        super(message);
    }
}