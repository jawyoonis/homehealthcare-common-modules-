package com.homehealthcare.homehealthcare_common_modules.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Schema(description = "Data Transfer Object for EVV Visit Timesheet information")
public class EVVVisitTimesheetDTO {

    @Schema(description = "Unique identifier for the visit timesheet", accessMode = Schema.AccessMode.READ_ONLY)
    private int id;

    @Schema(description = "ID of the associated client", example = "14")
    @NotNull(message = "Client ID is required")
    private Long clientId;

    @Schema(description = "ID of the associated caregiver", example = "3")
    @NotNull(message = "Caregiver ID is required")
    private Long caregiverId;

    @Schema(description = "Associated schedule information", example = "1")
    @NotNull(message = "Schedule ID is required")
    private Long scheduleId;

    @Schema(description = "Actual time when caregiver clocked in", example = "2024-03-15T09:00:00")
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", timezone = "UTC")
    @NotNull(message = "Clock-in time is required")
    private LocalDateTime actualClockedInTime;

    @Schema(description = "Actual time when caregiver clocked out", example = "2024-03-15T17:00:00")
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", timezone = "UTC")
    private LocalDateTime actualClockedOutTime;

    @Schema(description = "Total hours worked during the visit", example = "8.0", accessMode = Schema.AccessMode.READ_ONLY)
    private Double totalHoursWorked;

    @Schema(description = "Indicates if the caregiver was late for the visit", example = "false", accessMode = Schema.AccessMode.READ_ONLY)
    @NotNull(message = "Late status is required")
    private boolean isLate;

    @Schema(description = "Number of minutes the caregiver was delayed", example = "0", accessMode = Schema.AccessMode.READ_ONLY)
    private int delayMinutes;

    @Schema(description = "Latitude coordinate where caregiver clocked in", example = "40.7128")
    @NotNull(message = "Clock-in latitude is required")
    private double clockedInLatitude;

    @Schema(description = "Longitude coordinate where caregiver clocked in", example = "-74.0060")
    @NotNull(message = "Clock-in longitude is required")
    private double clockedInLongitude;

    @Schema(description = "Latitude coordinate where caregiver clocked out", example = "40.7128")
    private Double clockedOutLatitude;

    @Schema(description = "Longitude coordinate where caregiver clocked out", example = "-74.0060")
    private Double clockedOutLongitude;

    @Schema(description = "Device information used for clock-in")
    private DeviceInfoDTO clockInDeviceInfo;

    @Schema(description = "Device information used for clock-out")
    private DeviceInfoDTO clockOutDeviceInfo;

    @Schema(description = "Additional notes about the visit", example = "Client was cooperative and completed all scheduled activities")
    private String notes;

    @Schema(description = "Method used to verify the visit", example = "GPS", allowableValues = {"GPS", "BIOMETRIC", "SIGNATURE", "NONE"})
    private String verificationMethod;

    @Schema(description = "Type of service provided during the visit", example = "Personal Care")
    private String serviceType;

    @Schema(description = "Current status of the visit", example = "COMPLETED", allowableValues = {"PENDING", "IN_PROGRESS", "COMPLETED", "CANCELLED"})
    private String status;

    @Schema(description = "Indicates if the visit has been verified", example = "true")
    private boolean verified;
}