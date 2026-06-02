package com.zeldev.streaming_service.controllers;

import com.zeldev.streaming_service.request.SubscriberRequest;
import com.zeldev.streaming_service.service.SubscriberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("/api/subscribers")
@RequiredArgsConstructor
public class SubscriberController {
    private final SubscriberService service;

    @PostMapping("/subscribe")
    public ResponseEntity<String> register(@RequestBody SubscriberRequest request) {
        service.add(request);
        return ResponseEntity.status(OK).body("Account created!");
    }
}
