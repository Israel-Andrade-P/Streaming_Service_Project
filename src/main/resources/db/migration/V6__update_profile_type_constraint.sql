ALTER TABLE profiles
DROP CONSTRAINT IF EXISTS chk_profile_type;

ALTER TABLE profiles
ADD CONSTRAINT chk_profile_type
CHECK (profile_type IN ('KIDS', 'TEEN', 'ADULT'));