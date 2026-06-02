package com.zeldev.streaming_service.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record SubscriberRequest(
        @NotNull(message = "Username field is mandatory")
        @NotEmpty(message = "Username field is mandatory")
        @Size(min = 2, max = 50, message = "Username must be between 2 - 50 characters")
        String username,
        @NotNull(message = "Email field is mandatory")
        @NotEmpty(message = "Email field is mandatory")
        @Email(message = "Invalid email")
        String email,
        @NotNull(message = "Password field is mandatory")
        @NotEmpty(message = "Password field is mandatory")
        String password,
        @NotNull(message = "Account type field is mandatory")
        @NotEmpty(message = "Account type field is mandatory")
        String accountType
) {
}
