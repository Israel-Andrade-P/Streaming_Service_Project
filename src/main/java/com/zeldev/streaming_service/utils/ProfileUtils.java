package com.zeldev.streaming_service.utils;

import com.zeldev.streaming_service.enumeration.ProfileType;
import com.zeldev.streaming_service.exception.InvalidProfileTypeException;
import com.zeldev.streaming_service.model.Profile;
import com.zeldev.streaming_service.request.ProfileRequest;

import java.util.Arrays;

public class ProfileUtils {
    public static Profile toProfile (ProfileRequest request) {
        return Profile.builder()
                .profileName(request.profileName())
                .profileType(typeValidation(request.profileType()))
                .build();
    }

    private  static ProfileType typeValidation(String profType) {
        return Arrays.stream(ProfileType.values())
                .filter(type -> type.name().equals(profType))
                .findFirst()
                .orElseThrow(() -> new InvalidProfileTypeException("Profile Type not supported"));
    }
}
