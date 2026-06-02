CREATE TABLE IF NOT EXISTS profiles (
    id BIGINT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    subscriber_id BIGINT NOT NULL,
    profile_name VARCHAR(100) NOT NULL,
    profile_type VARCHAR(20) NOT NULL,
    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    last_modified_at TIMESTAMP,
    CONSTRAINT fk_profiles_subscribers FOREIGN KEY (subscriber_id) REFERENCES subscribers(id) ON DELETE CASCADE,
    CONSTRAINT chk_profile_type CHECK (profile_type IN ('KID', 'TEENAGER'))
);