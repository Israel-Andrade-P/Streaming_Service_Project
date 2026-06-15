package com.zeldev.streaming_service.enumeration;

public enum AccountType {
    BASIC(0),
    STANDARD(2),
    PREMIUM(4);

    private final int maxProfiles;

     AccountType(int maxProfiles) {
        this.maxProfiles = maxProfiles;
    }

    public int getMaxProfiles() {
         return maxProfiles;
    }
}
