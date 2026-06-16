package com.zeldev.streaming_service.controllers;

import com.zeldev.streaming_service.request.ChangeSubscriptionRequest;
import com.zeldev.streaming_service.request.SubscriberRequest;
import com.zeldev.streaming_service.service.SubscriberService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("/api/subscribers")
@RequiredArgsConstructor
public class SubscriberController {
    private final SubscriberService service;

    @PostMapping("/subscribe")
    public ResponseEntity<String> register(@RequestBody @Valid SubscriberRequest request) {
        service.add(request);
        return ResponseEntity.status(CREATED).body("Account created!");
    }

    @PatchMapping("/account-type")
    public ResponseEntity<String> changeSubscription(@RequestBody ChangeSubscriptionRequest request) {
        return ResponseEntity.status(OK).body(service.updateAcc(request.accountType()));
    }
}
