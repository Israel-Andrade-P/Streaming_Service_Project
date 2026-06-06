package com.zeldev.streaming_service.service;

import com.zeldev.streaming_service.repositories.SubscriberRepository;
import com.zeldev.streaming_service.request.SubscriberRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import static com.zeldev.streaming_service.utils.SubscriberUtils.toSub;

@Service
@RequiredArgsConstructor
public class SubscriberService {
    private final SubscriberRepository subscriberRepository;
    private final PasswordEncoder passwordEncoder;

    public void add(SubscriberRequest request) {
        var encoded = passwordEncoder.encode(request.password());
        subscriberRepository.save(toSub(request, encoded));
    }
}
