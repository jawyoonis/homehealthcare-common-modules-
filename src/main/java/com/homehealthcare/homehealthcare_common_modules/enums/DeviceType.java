package com.homehealthcare.homehealthcare_common_modules.enums;

public enum DeviceType {
    DESKTOP("Desktop"),
    TABLET("Tablet"),
    PHONE("Phone"),
    LAPTOP("Laptop"),
    SMARTWATCH("Smartwatch"),
    OTHER("Other");

    private final String displayName;

    DeviceType(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}
