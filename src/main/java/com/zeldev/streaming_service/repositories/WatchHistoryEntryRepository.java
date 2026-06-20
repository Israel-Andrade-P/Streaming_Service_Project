package com.zeldev.streaming_service.repositories;

import com.zeldev.streaming_service.model.WatchHistoryEntry;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface WatchHistoryEntryRepository extends JpaRepository<WatchHistoryEntry, Long> {
    @Query("""
    SELECT whe
    FROM WatchHistoryEntry whe
    WHERE whe.profile.id=?1
    ORDER BY whe.watchedAt DESC
""")
    List<WatchHistoryEntry> findHistoryByProfile(Long profileId);

    @Query("SELECT whe FROM WatchHistoryEntry whe WHERE whe.profile.id=?1 ORDER BY whe.watchedAt DESC")
    List<WatchHistoryEntry> findByProfileId(Long id);
}
