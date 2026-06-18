package com.zeldev.streaming_service.response;

import com.zeldev.streaming_service.enumeration.AgeRestriction;
import lombok.Builder;

@Builder
public record MovieResponse(
        String title,
        Integer durationMins,
        Integer releaseYear,
        String description,
        AgeRestriction ageRestriction
) {}
