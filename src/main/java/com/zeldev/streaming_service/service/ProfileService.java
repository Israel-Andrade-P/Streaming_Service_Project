package com.zeldev.streaming_service.service;

import com.zeldev.streaming_service.model.Subscriber;
import com.zeldev.streaming_service.repositories.ProfileRepository;
import com.zeldev.streaming_service.repositories.SubscriberRepository;
import com.zeldev.streaming_service.request.ProfileDto;
import com.zeldev.streaming_service.utils.ProfileUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.zeldev.streaming_service.utils.ProfileUtils.toProfile;

@Service
@RequiredArgsConstructor
public class ProfileService {
    private final ProfileRepository profileRepository;
    private final SubscriberRepository subscriberRepository;

    public void add(ProfileDto request) {
        profileRepository.save(toProfile(request, getSub()));
    }

    public List<ProfileDto> getProfiles() {
        return profileRepository.findProfiles(getSub().getEmail()).stream().map(ProfileUtils::toDto).toList();
    }

    private Subscriber getSub() {
        var auth = SecurityContextHolder.getContext().getAuthentication();
        return subscriberRepository.findByEmail(auth.getName()).orElseThrow();
    }
}
