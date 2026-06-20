package com.zeldev.streaming_service.utils;

import com.zeldev.streaming_service.model.Movie;
import com.zeldev.streaming_service.model.WatchHistoryEntry;
import com.zeldev.streaming_service.response.MovieResponse;
import com.zeldev.streaming_service.response.WatchHistoryResponse;

import java.util.List;

public class MovieUtils {

    public static MovieResponse toResponse(Movie movie) {
        return MovieResponse.builder()
                .title(movie.getTitle())
                .ageRestriction(movie.getAgeRestriction())
                .description(movie.getDescription())
                .durationMins(movie.getDurationMins())
                .releaseYear(movie.getReleaseYear())
                .build();
    }

    public static WatchHistoryResponse toWatchHistoryResponse(WatchHistoryEntry watchHistoryEntry) {
        return WatchHistoryResponse.builder()
                .movieTitle(watchHistoryEntry.getMovie().getTitle())
                .watchedWhen(watchHistoryEntry.getWatchedAt())
                .build();
    }
}
