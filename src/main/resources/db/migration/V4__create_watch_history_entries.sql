CREATE TABLE IF NOT EXISTS watch_history_entries (
    id BIGINT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    profile_id BIGINT NOT NULL,
    movie_id BIGINT NOT NULL,
    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,

    CONSTRAINT fk_watch_history_profile FOREIGN KEY (profile_id) REFERENCES profiles(id),

    CONSTRAINT fk_watch_history_movie FOREIGN KEY (movie_id) REFERENCES movies(id)
);

CREATE INDEX IF NOT EXISTS idx_watch_history_profile ON watch_history_entries(profile_id);

CREATE INDEX IF NOT EXISTS idx_watch_history_movie ON watch_history_entries(movie_id);

CREATE INDEX IF NOT EXISTS idx_watch_history_created_at ON watch_history_entries(created_at);