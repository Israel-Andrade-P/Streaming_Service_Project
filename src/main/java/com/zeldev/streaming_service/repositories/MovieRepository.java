package com.zeldev.streaming_service.repositories;

import com.zeldev.streaming_service.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepository extends JpaRepository<Movie, Long> {
}
