package com.zeldev.streaming_service.utils;

import com.zeldev.streaming_service.model.Movie;
import com.zeldev.streaming_service.response.MovieResponse;

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
}
