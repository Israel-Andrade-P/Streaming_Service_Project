package com.zeldev.streaming_service.exception;

public class InvalidMovieException extends RuntimeException{
    public InvalidMovieException(String message) {
        super(message);
    }
}
