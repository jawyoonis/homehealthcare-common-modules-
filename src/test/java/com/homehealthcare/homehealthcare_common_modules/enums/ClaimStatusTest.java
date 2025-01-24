package com.homehealthcare.homehealthcare_common_modules.enums;

import org.junit.jupiter.api.Test;

import java.util.EnumSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class ClaimStatusTest {

    @Test
    void testEnumValues() {
        // Ensure all enum values are defined correctly
        ClaimStatus[] statuses = ClaimStatus.values();
        assertEquals(6, statuses.length, "Expected 6 ClaimStatus values");
        assertArrayEquals(
                new ClaimStatus[]{ClaimStatus.DRAFT, ClaimStatus.SUBMITTED, ClaimStatus.IN_PROGRESS,
                        ClaimStatus.ACCEPTED, ClaimStatus.REJECTED, ClaimStatus.RESUBMITTED},
                statuses,
                "Enum values do not match expected order"
        );
    }

    @Test
    void testValueOf() {
        // Test if the enum can return valid values
        assertEquals(ClaimStatus.DRAFT, ClaimStatus.valueOf("DRAFT"));
        assertEquals(ClaimStatus.SUBMITTED, ClaimStatus.valueOf("SUBMITTED"));
        assertEquals(ClaimStatus.IN_PROGRESS, ClaimStatus.valueOf("IN_PROGRESS"));
        assertEquals(ClaimStatus.ACCEPTED, ClaimStatus.valueOf("ACCEPTED"));
        assertEquals(ClaimStatus.REJECTED, ClaimStatus.valueOf("REJECTED"));
        assertEquals(ClaimStatus.RESUBMITTED, ClaimStatus.valueOf("RESUBMITTED"));
    }

    @Test
    void testInvalidValueOfThrowsException() {
        // Ensure that invalid value throws IllegalArgumentException
        assertThrows(IllegalArgumentException.class, () -> ClaimStatus.valueOf("INVALID"));
    }

    @Test
    void testToString() {
        // Verify the string representation of each enum
        assertEquals("DRAFT", ClaimStatus.DRAFT.toString());
        assertEquals("SUBMITTED", ClaimStatus.SUBMITTED.toString());
        assertEquals("IN_PROGRESS", ClaimStatus.IN_PROGRESS.toString());
        assertEquals("ACCEPTED", ClaimStatus.ACCEPTED.toString());
        assertEquals("REJECTED", ClaimStatus.REJECTED.toString());
        assertEquals("RESUBMITTED", ClaimStatus.RESUBMITTED.toString());
    }

    @Test
    void testEnumSetContainsAllValues() {
        // Verify that an EnumSet contains all ClaimStatus values
        Set<ClaimStatus> statusSet = EnumSet.allOf(ClaimStatus.class);
        assertTrue(statusSet.contains(ClaimStatus.DRAFT));
        assertTrue(statusSet.contains(ClaimStatus.SUBMITTED));
        assertTrue(statusSet.contains(ClaimStatus.IN_PROGRESS));
        assertTrue(statusSet.contains(ClaimStatus.ACCEPTED));
        assertTrue(statusSet.contains(ClaimStatus.REJECTED));
        assertTrue(statusSet.contains(ClaimStatus.RESUBMITTED));
        assertEquals(6, statusSet.size(), "EnumSet should contain exactly 6 elements");
    }

    @Test
    void testOrdinalValues() {
        // Test the ordinal values of the enum constants
        assertEquals(0, ClaimStatus.DRAFT.ordinal());
        assertEquals(1, ClaimStatus.SUBMITTED.ordinal());
        assertEquals(2, ClaimStatus.IN_PROGRESS.ordinal());
        assertEquals(3, ClaimStatus.ACCEPTED.ordinal());
        assertEquals(4, ClaimStatus.REJECTED.ordinal());
        assertEquals(5, ClaimStatus.RESUBMITTED.ordinal());
    }

    @Test
    void testSwitchCaseBehavior() {
        // Test using ClaimStatus in a switch statement
        ClaimStatus status = ClaimStatus.IN_PROGRESS;
        String message;

        switch (status) {
            case DRAFT -> message = "The claim is in draft state.";
            case SUBMITTED -> message = "The claim has been submitted.";
            case IN_PROGRESS -> message = "The claim is being processed.";
            case ACCEPTED -> message = "The claim has been accepted.";
            case REJECTED -> message = "The claim was rejected.";
            case RESUBMITTED -> message = "The claim has been resubmitted.";
            default -> throw new IllegalStateException("Unexpected value: " + status);
        }

        assertEquals("The claim is being processed.", message);
    }
}
