package com.zeldev.streaming_service.service;

import com.zeldev.streaming_service.enumeration.AccountType;
import com.zeldev.streaming_service.exception.AccountProfileException;
import com.zeldev.streaming_service.model.Subscriber;
import com.zeldev.streaming_service.repositories.ProfileRepository;
import com.zeldev.streaming_service.repositories.SubscriberRepository;
import com.zeldev.streaming_service.request.SubscriberRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import static com.zeldev.streaming_service.utils.ProfileUtils.toProfile;
import static com.zeldev.streaming_service.utils.SubscriberUtils.toSub;

@Service
@RequiredArgsConstructor
public class SubscriberService {
    private final SubscriberRepository subscriberRepository;
    private final ProfileRepository profileRepository;
    private final PasswordEncoder passwordEncoder;

    @Transactional
    public void add(SubscriberRequest request) {
        var encoded = passwordEncoder.encode(request.password());
        var sub = subscriberRepository.save(toSub(request, encoded));
        profileRepository.save(toProfile(sub));
    }

    @Transactional
    public String updateAcc(AccountType newAccType) {
        var auth = SecurityContextHolder.getContext().getAuthentication();
        var sub = subscriberRepository.findByEmail(auth.getName()).orElseThrow();

        if (sub.getAccountType().equals(newAccType)) return "Account status hasn't changed";

        validateDowngrade(sub, newAccType);

        sub.setAccountType(newAccType);

        return "Account status changed";
    }

    private void validateDowngrade(Subscriber sub, AccountType desiredType) {
        long profileCount = profileRepository.countBySubscriberId(sub.getId());

        switch (desiredType) {
            case BASIC -> {
                if (profileCount > 0) throw new AccountProfileException("Remove all profiles before downgrading to BASIC");
            }
            case STANDARD -> {
                if (profileCount > 2) throw new AccountProfileException("STANDARD supports at most 2 profiles");
            }
        }
    }
}
