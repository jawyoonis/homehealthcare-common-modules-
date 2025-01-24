package com.homehealthcare.homehealthcare_common_modules.enums;

public enum OperatingSystem {
    ANDROID("Android"),
    IOS("iOS"),
    WINDOWS("Windows"),
    LINUX("Linux");

    private final String displayName;

    OperatingSystem(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}

