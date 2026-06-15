package com.zeldev.streaming_service.service;

import com.zeldev.streaming_service.exception.AccountProfileException;
import com.zeldev.streaming_service.model.Subscriber;
import com.zeldev.streaming_service.repositories.ProfileRepository;
import com.zeldev.streaming_service.repositories.SubscriberRepository;
import com.zeldev.streaming_service.request.ProfileDto;
import com.zeldev.streaming_service.utils.ProfileUtils;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.nio.file.AccessDeniedException;
import java.util.List;

import static com.zeldev.streaming_service.utils.ProfileUtils.toProfile;

@Service
@RequiredArgsConstructor
public class ProfileService {
    private final ProfileRepository profileRepository;
    private final SubscriberRepository subscriberRepository;

    public void add(ProfileDto request) {
        var sub = getSub();

        checkProfileLimit(sub);

        profileRepository.save(toProfile(request, sub));
    }

    public List<ProfileDto> getProfiles() {
        return profileRepository.findProfiles(getSub().getEmail()).stream().map(ProfileUtils::toDto).toList();
    }

    public void selectProfile(Long id, HttpSession session) throws AccessDeniedException {
        var sub = getSub();
        var profile = profileRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Profile doesn't exist"));

        if (!sub.getId().equals(profile.getSubscriber().getId())) throw new AccessDeniedException("Not your profile!");

        session.setAttribute("selectedProfile", id);
    }

    private Subscriber getSub() {
        var auth = SecurityContextHolder.getContext().getAuthentication();
        return subscriberRepository.findByEmail(auth.getName()).orElseThrow();
    }

    private void checkProfileLimit(Subscriber sub) {
        var maxProfiles = sub.getAccountType().getMaxProfiles();

        if (maxProfiles == 0) throw new AccountProfileException("Profile creation not available for Basic accounts");

        long profileCount = profileRepository.countBySubscriberId(sub.getId());

        if (profileCount >= maxProfiles) throw new AccountProfileException("Maximum profile limit reached");
    }
}
