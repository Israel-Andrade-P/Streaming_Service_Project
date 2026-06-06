package com.zeldev.streaming_service.repositories;

import com.zeldev.streaming_service.model.Subscriber;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface SubscriberRepository extends JpaRepository<Subscriber, Long> {

    @Query("SELECT s FROM Subscriber s WHERE s.email=?1")
    Optional<Subscriber> findByEmail(String email);
}
