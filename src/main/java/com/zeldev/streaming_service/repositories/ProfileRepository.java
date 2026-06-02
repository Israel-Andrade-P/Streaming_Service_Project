package com.zeldev.streaming_service.repositories;

import com.zeldev.streaming_service.model.Profile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfileRepository extends JpaRepository<Profile, Long> {
}
