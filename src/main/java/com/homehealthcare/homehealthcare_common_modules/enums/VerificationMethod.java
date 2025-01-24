package com.homehealthcare.homehealthcare_common_modules.enums;

public enum VerificationMethod {
    GPS,
    BIOMETRIC,
    SIGNATURE,
    NONE; // Represents an unverified timesheet

    // Method to check if the method is valid for verification
    public boolean isVerified() {
        // Only some methods are considered valid verification methods
        return this != NONE;
    }
}
