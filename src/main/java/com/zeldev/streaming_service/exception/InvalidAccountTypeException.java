package com.zeldev.streaming_service.exception;

public class InvalidAccountTypeException extends RuntimeException {
    public InvalidAccountTypeException(String message) {
        super(message);
    }
}
