package com.zeldev.streaming_service.request;

import jakarta.validation.constraints.NotNull;
import lombok.Builder;

@Builder
public record ProfileDto(
        @NotNull(message = "Profile name required")
        String profileName,
        @NotNull(message = "Profile type required")
        String profileType) {
}
