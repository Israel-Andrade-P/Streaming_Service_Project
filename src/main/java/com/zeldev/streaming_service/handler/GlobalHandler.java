package com.zeldev.streaming_service.handler;

import com.zeldev.streaming_service.exception.AccountProfileException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalHandler {

    @ExceptionHandler(AccountProfileException.class)
    public ResponseEntity<String> handler(AccountProfileException exp) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(exp.getMessage());
    }
}
