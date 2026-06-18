package com.zeldev.streaming_service.utils;

import com.zeldev.streaming_service.enumeration.AgeRestriction;
import com.zeldev.streaming_service.exception.InvalidProfileTypeException;
import com.zeldev.streaming_service.model.Profile;
import com.zeldev.streaming_service.model.Subscriber;
import com.zeldev.streaming_service.request.ProfileDto;

import java.util.Arrays;

public class ProfileUtils {
    public static Profile toProfile (ProfileDto request, Subscriber subscriber) {
        return Profile.builder()
                .profileName(request.profileName())
                .ageRestriction(typeValidation(request.profileType()))
                .subscriber(subscriber)
                .build();
    }

    public static Profile toProfile(Subscriber subscriber) {
        return Profile.builder()
                .profileName(subscriber.getUsername())
                .ageRestriction(AgeRestriction.ADULT)
                .subscriber(subscriber)
                .build();
    }

    public static ProfileDto toDto(Profile profile) {
        return ProfileDto.builder()
                .profileName(profile.getProfileName())
                .profileType(profile.getAgeRestriction().name())
                .build();
    }

    private  static AgeRestriction typeValidation(String profType) {
        return Arrays.stream(AgeRestriction.values())
                .filter(type -> type.name().equals(profType))
                .findFirst()
                .orElseThrow(() -> new InvalidProfileTypeException("Profile Type not supported"));
    }
}
