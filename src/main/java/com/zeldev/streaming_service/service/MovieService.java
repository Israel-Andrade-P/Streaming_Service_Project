package com.zeldev.streaming_service.service;

import com.zeldev.streaming_service.exception.InvalidMovieException;
import com.zeldev.streaming_service.exception.ProfileNotFoundException;
import com.zeldev.streaming_service.exception.ProfileNotSelectedException;
import com.zeldev.streaming_service.model.Movie;
import com.zeldev.streaming_service.model.Profile;
import com.zeldev.streaming_service.model.WatchHistoryEntry;
import com.zeldev.streaming_service.repositories.MovieRepository;
import com.zeldev.streaming_service.repositories.ProfileRepository;
import com.zeldev.streaming_service.repositories.WatchHistoryEntryRepository;
import com.zeldev.streaming_service.response.MovieResponse;
import com.zeldev.streaming_service.response.WatchHistoryResponse;
import com.zeldev.streaming_service.utils.MovieUtils;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.jspecify.annotations.Nullable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MovieService {
    private final MovieRepository movieRepository;
    private final ProfileRepository profileRepository;
    private final WatchHistoryEntryRepository wheRepository;
    private final ProfileService profileService;

    public List<MovieResponse> getMovies(HttpSession session) {
        var profile = profileService.getProfileFromSession(session);

        return movieRepository
                .findAll()
                .stream()
                .filter(movie -> checkAgeAndAccType(movie, profile))
                .map(MovieUtils::toResponse)
                .toList();
    }

    public void watchMovie(Long movieId, HttpSession session) {
        var profile = profileService.getProfileFromSession(session);
        var movie = movieRepository.findById(movieId).orElseThrow(() -> new InvalidMovieException("Movie not available"));

        if (!checkAgeAndAccType(movie, profile)) throw new InvalidMovieException("Movie not available");

        try {
            System.out.println("Movie being watched");
            Thread.sleep(5000);
            System.out.println("Movie ended");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        wheRepository.save(new WatchHistoryEntry(profile, movie));
    }

    public List<WatchHistoryResponse> getWatchHistory(HttpSession session) {
        var profile = profileService.getProfileFromSession(session);

        return wheRepository.findByProfileId(profile.getId())
                .stream()
                .map(MovieUtils::toWatchHistoryResponse)
                .toList();
    }

    private boolean checkAgeAndAccType(Movie movie, Profile profile) {
        var accountType = profile.getSubscriber().getAccountType();
        var accountLevel = accountType.getLevel();
        var profileAgeLevel = profile.getAgeRestriction().getLevel();

        return movie.getRequiredAccountType().getLevel() <= accountLevel &&
                movie.getAgeRestriction().getLevel() <= profileAgeLevel;
    }
}
