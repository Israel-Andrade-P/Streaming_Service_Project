package com.zeldev.streaming_service.service;

import com.zeldev.streaming_service.repositories.SubscriberRepository;
import com.zeldev.streaming_service.request.SubscriberRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import static com.zeldev.streaming_service.utils.SubscriberUtils.toSub;

@Service
@RequiredArgsConstructor
public class SubscriberService {
    private SubscriberRepository subscriberRepository;

    public void add(SubscriberRequest request) {
        subscriberRepository.save(toSub(request));
    }
}
