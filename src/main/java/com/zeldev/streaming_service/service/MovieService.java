package com.zeldev.streaming_service.service;

import com.zeldev.streaming_service.exception.ProfileNotFoundException;
import com.zeldev.streaming_service.exception.ProfileNotSelectedException;
import com.zeldev.streaming_service.repositories.MovieRepository;
import com.zeldev.streaming_service.repositories.ProfileRepository;
import com.zeldev.streaming_service.response.MovieResponse;
import com.zeldev.streaming_service.utils.MovieUtils;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MovieService {
    private final MovieRepository movieRepository;
    private final ProfileRepository profileRepository;

    public List<MovieResponse> getMovies(HttpSession session) {
        Long profileId = (Long) session.getAttribute("selectedProfile");

        if (profileId == null) throw new ProfileNotSelectedException("No profile selected");

        var profile = profileRepository.findById(profileId).orElseThrow(() -> new ProfileNotFoundException("Profile doesn't exist"));
        var accountType = profile.getSubscriber().getAccountType();
        var accountLevel = accountType.getLevel();
        var profileAgeLevel = profile.getAgeRestriction().getLevel();

        return movieRepository
                .findAll()
                .stream()
                .filter(movie ->
                        movie.getRequiredAccountType().getLevel() <= accountLevel &&
                        movie.getAgeRestriction().getLevel() <= profileAgeLevel
                )
                .map(MovieUtils::toResponse)
                .toList();
    }
}
