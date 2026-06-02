package com.zeldev.streaming_service.repositories;

import com.zeldev.streaming_service.model.Subscriber;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubscriberRepository extends JpaRepository<Subscriber, Long> {
}
