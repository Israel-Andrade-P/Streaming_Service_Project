package com.zeldev.streaming_service.controllers;

import com.zeldev.streaming_service.request.ProfileDto;
import com.zeldev.streaming_service.service.ProfileService;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.nio.file.AccessDeniedException;
import java.util.List;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

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

    @GetMapping("/all")
    public ResponseEntity<List<ProfileDto>> getProfiles() {
        return ResponseEntity.status(OK).body(profileService.getProfiles());
    }

    @PostMapping("/{profileId}/select")
    public ResponseEntity<String> selectProfile(@PathVariable("profileId") Long id, HttpSession session) throws AccessDeniedException {
        profileService.selectProfile(id, session);
        return ResponseEntity.status(OK).body("Profile selected");
    }

    @GetMapping("/current")
    public ResponseEntity<String> getProfiles(HttpSession session) {
        var profileId = (Long) session.getAttribute("selectedProfile");
        return ResponseEntity.status(OK).body(String.format("Current Profile: %d", profileId));
    }
}
