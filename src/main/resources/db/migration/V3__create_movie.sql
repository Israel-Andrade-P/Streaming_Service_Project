CREATE TABLE IF NOT EXISTS movies (
    id BIGINT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    title VARCHAR(100) NOT NULL,
    description VARCHAR(1000) NOT NULL,
    duration_mins INTEGER NOT NULL,
    age_restriction VARCHAR(20) NOT NULL,
    required_account_type VARCHAR(20) NOT NULL,
    release_year INTEGER NOT NULL,
    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    last_modified_at TIMESTAMP
);