package com.zeldev.streaming_service.controllers;

import com.zeldev.streaming_service.response.MovieResponse;
import com.zeldev.streaming_service.service.MovieService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/movies")
@RequiredArgsConstructor
public class MovieController {
    private final MovieService movieService;

    @GetMapping("/list")
    public ResponseEntity<List<MovieResponse>> getMovies(HttpSession session) {
        return ResponseEntity.status(HttpStatus.OK).body(movieService.getMovies(session));
    }
}
