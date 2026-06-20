package com.zeldev.streaming_service.response;

import lombok.Builder;

import java.time.LocalDateTime;

@Builder
public record WatchHistoryResponse(String movieTitle, LocalDateTime watchedWhen) {
}
