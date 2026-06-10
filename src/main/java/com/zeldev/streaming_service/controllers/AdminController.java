package com.zeldev.streaming_service.controllers;

import com.zeldev.streaming_service.request.ProfileDto;
import com.zeldev.streaming_service.service.ProfileService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/admin")
@RequiredArgsConstructor
public class AdminController {
    private final ProfileService service;

    @GetMapping("/profiles")
    public ResponseEntity<List<ProfileDto>> getProfiles() {
        return ResponseEntity.status(HttpStatus.OK).body(service.getProfiles());
    }
}


