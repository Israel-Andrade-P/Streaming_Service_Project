package com.zeldev.streaming_service.enumeration;

public enum AgeRestriction {
    KIDS(1),
    TEEN(2),
    ADULT(3);

    private final int level;

    AgeRestriction(int level) {
        this.level = level;
    }

    public int getLevel() {
        return level;
    }
}