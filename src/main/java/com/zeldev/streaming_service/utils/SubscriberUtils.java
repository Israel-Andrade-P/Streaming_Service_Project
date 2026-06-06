package com.zeldev.streaming_service.utils;

import com.zeldev.streaming_service.enumeration.AccountType;
import com.zeldev.streaming_service.exception.InvalidAccountTypeException;
import com.zeldev.streaming_service.model.Subscriber;
import com.zeldev.streaming_service.request.SubscriberRequest;

import java.util.Arrays;

public class SubscriberUtils {
    public static Subscriber toSub (SubscriberRequest request, String encodedPwd) {
        return Subscriber.builder()
                .username(request.username())
                .email(request.email())
                .password(encodedPwd)
                .accountType(typeValidation(request.accountType()))
                .build();
    }

    private  static AccountType typeValidation(String accType) {
        return Arrays.stream(AccountType.values())
                .filter(type -> type.name().equals(accType))
                .findFirst()
                .orElseThrow(() -> new InvalidAccountTypeException("Account Type not supported"));
    }
}
