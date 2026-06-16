package com.zeldev.streaming_service.request;

import com.zeldev.streaming_service.enumeration.AccountType;

public record ChangeSubscriptionRequest(AccountType accountType) {
}
