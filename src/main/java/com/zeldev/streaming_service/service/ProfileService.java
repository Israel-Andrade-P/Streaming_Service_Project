package com.zeldev.streaming_service.service;

import com.zeldev.streaming_service.repositories.ProfileRepository;
import com.zeldev.streaming_service.request.ProfileRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import static com.zeldev.streaming_service.utils.ProfileUtils.toProfile;

@Service
@RequiredArgsConstructor
public class ProfileService {
    private final ProfileRepository profileRepository;

    public void add(ProfileRequest request) {
        profileRepository.save(toProfile(request));
    }
}
