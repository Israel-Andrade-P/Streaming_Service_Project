package com.zeldev.streaming_service.controllers;

import com.zeldev.streaming_service.request.ProfileDto;
import com.zeldev.streaming_service.service.ProfileService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.HttpStatus.*;

@RestController
@RequestMapping("/api/profiles")
@RequiredArgsConstructor
public class ProfileController {
    private final ProfileService profileService;

    @PostMapping("/add")
    public ResponseEntity<String> addProfile(@RequestBody @Valid ProfileDto request) {
        profileService.add(request);
        return ResponseEntity.status(CREATED).body("Profile added");
    }
}
