package com.zeldev.streaming_service.request;

import jakarta.validation.constraints.NotNull;

public record ProfileRequest(
        @NotNull(message = "Profile name required")
        String profileName,
        @NotNull(message = "Profile type required")
        String profileType) {
}
