package com.zeldev.streaming_service.handler;

import com.zeldev.streaming_service.exception.AccountProfileException;
import com.zeldev.streaming_service.exception.InvalidMovieException;
import com.zeldev.streaming_service.exception.ProfileNotFoundException;
import com.zeldev.streaming_service.exception.ProfileNotSelectedException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.nio.file.AccessDeniedException;

@RestControllerAdvice
public class GlobalHandler {

    @ExceptionHandler(AccountProfileException.class)
    public ResponseEntity<String> handler(AccountProfileException exp) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(exp.getMessage());
    }

    @ExceptionHandler(InvalidMovieException.class)
    public ResponseEntity<String> handler(InvalidMovieException exp) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(exp.getMessage());
    }

    @ExceptionHandler(ProfileNotFoundException.class)
    public ResponseEntity<String> handler(ProfileNotFoundException exp) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(exp.getMessage());
    }

    @ExceptionHandler(ProfileNotSelectedException.class)
    public ResponseEntity<String> handler(ProfileNotSelectedException exp) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(exp.getMessage());
    }

    @ExceptionHandler(AccessDeniedException.class)
    public ResponseEntity<String> handler(AccessDeniedException exp) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(exp.getMessage());
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handler(Exception exp) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(exp.getMessage());
    }
}
