package com.zeldev.streaming_service.repositories;

import com.zeldev.streaming_service.model.Profile;
import com.zeldev.streaming_service.request.ProfileDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProfileRepository extends JpaRepository<Profile, Long> {

    @Query("SELECT p FROM Profile p WHERE p.subscriber.email=?1")
    List<Profile> findProfiles(String email);
}
