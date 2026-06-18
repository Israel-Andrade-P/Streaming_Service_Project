package com.zeldev.streaming_service.enumeration;

public enum AccountType {
    BASIC(1, 1),
    STANDARD(2, 2),
    PREMIUM(4, 3);

    private final int maxProfiles;
    private final int level;

     AccountType(int maxProfiles, int level) {
        this.maxProfiles = maxProfiles;
        this.level = level;
    }

    public int getMaxProfiles() {
         return maxProfiles;
    }

    public int getLevel() {
         return level;
    }
}
