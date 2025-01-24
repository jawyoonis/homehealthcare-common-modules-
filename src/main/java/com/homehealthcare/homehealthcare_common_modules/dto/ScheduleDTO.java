package com.homehealthcare.homehealthcare_common_modules.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Data
@Schema(description = "Data Transfer Object for Schedule information")
public class ScheduleDTO {

    @Schema(description = "Unique identifier of the schedule", accessMode = Schema.AccessMode.READ_ONLY)
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Long id;

    @Schema(description = "ID of the associated client", example = "871")
    private Long clientId;

    @Schema(description = "ID of the assigned employee", example = "1538")
    private Long employeeId;

    @Schema(description = "ID of the replacement employee, if assigned", nullable = true, example = "null")
    private Long replacementEmployeeId;

    // **New Fields for Client Names**
    @Schema(description = "First name of the associated client")
    private String clientFirstName;

    @Schema(description = "Last name of the associated client")
    private String clientLastName;

    // **New Fields for Employee Names**
    @Schema(description = "First name of the assigned employee")
    private String employeeFirstName;

    @Schema(description = "Last name of the assigned employee")
    private String employeeLastName;

    // **New Fields for Replacement Employee Names**
    @Schema(description = "First name of the replacement employee, if assigned")
    private String replacementEmployeeFirstName;

    @Schema(description = "Last name of the replacement employee, if assigned")
    private String replacementEmployeeLastName;

    // Day-specific hours
    @Schema(description = "Hours scheduled for Monday")
    private Double mondayHours;

    @Schema(description = "Hours scheduled for Tuesday")
    private Double tuesdayHours;

    @Schema(description = "Hours scheduled for Wednesday")
    private Double wednesdayHours;

    @Schema(description = "Hours scheduled for Thursday")
    private Double thursdayHours;

    @Schema(description = "Hours scheduled for Friday")
    private Double fridayHours;

    @Schema(description = "Hours scheduled for Saturday")
    private Double saturdayHours;

    @Schema(description = "Hours scheduled for Sunday")
    private Double sundayHours;

    @Schema(type = "string", format = "date", example = "2024-09-22", description = "Date of the schedule")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate scheduleDate;

    // Day-specific clock-in and clock-out times
    @Schema(type = "string", format = "time", example = "09:00:00", description = "Planned clock-in time for Monday")
    @JsonFormat(pattern = "HH:mm:ss")
    private LocalTime mondayClockedInTime;

    @Schema(type = "string", format = "time", example = "17:00:00", description = "Planned clock-out time for Monday")
    @JsonFormat(pattern = "HH:mm:ss")
    private LocalTime mondayClockedOutTime;

    @Schema(type = "string", format = "time", example = "09:00:00", description = "Planned clock-in time for Tuesday")
    @JsonFormat(pattern = "HH:mm:ss")
    private LocalTime tuesdayClockedInTime;

    @Schema(type = "string", format = "time", example = "17:00:00", description = "Planned clock-out time for Tuesday")
    @JsonFormat(pattern = "HH:mm:ss")
    private LocalTime tuesdayClockedOutTime;

    @Schema(type = "string", format = "time", example = "09:00:00", description = "Planned clock-in time for Wednesday")
    @JsonFormat(pattern = "HH:mm:ss")
    private LocalTime wednesdayClockedInTime;

    @Schema(type = "string", format = "time", example = "17:00:00", description = "Planned clock-out time for Wednesday")
    @JsonFormat(pattern = "HH:mm:ss")
    private LocalTime wednesdayClockedOutTime;

    @Schema(type = "string", format = "time", example = "09:00:00", description = "Planned clock-in time for Thursday")
    @JsonFormat(pattern = "HH:mm:ss")
    private LocalTime thursdayClockedInTime;

    @Schema(type = "string", format = "time", example = "17:00:00", description = "Planned clock-out time for Thursday")
    @JsonFormat(pattern = "HH:mm:ss")
    private LocalTime thursdayClockedOutTime;

    @Schema(type = "string", format = "time", example = "09:00:00", description = "Planned clock-in time for Friday")
    @JsonFormat(pattern = "HH:mm:ss")
    private LocalTime fridayClockedInTime;

    @Schema(type = "string", format = "time", example = "17:00:00", description = "Planned clock-out time for Friday")
    @JsonFormat(pattern = "HH:mm:ss")
    private LocalTime fridayClockedOutTime;

    @Schema(type = "string", format = "time", example = "09:00:00", description = "Planned clock-in time for Saturday")
    @JsonFormat(pattern = "HH:mm:ss")
    private LocalTime saturdayClockedInTime;

    @Schema(type = "string", format = "time", example = "17:00:00", description = "Planned clock-out time for Saturday")
    @JsonFormat(pattern = "HH:mm:ss")
    private LocalTime saturdayClockedOutTime;

    @Schema(type = "string", format = "time", example = "09:00:00", description = "Planned clock-in time for Sunday")
    @JsonFormat(pattern = "HH:mm:ss")
    private LocalTime sundayClockedInTime;

    @Schema(type = "string", format = "time", example = "17:00:00", description = "Planned clock-out time for Sunday")
    @JsonFormat(pattern = "HH:mm:ss")
    private LocalTime sundayClockedOutTime;

    @Schema(description = "Current status of the schedule")
    private String status;

    /**
     * Creation timestamp. Read-only to prevent client modification.
     */
    @Schema(accessMode = Schema.AccessMode.READ_ONLY, description = "Timestamp when the schedule was created")
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private LocalDateTime createdAt;

    /**
     * Last update timestamp. Read-only to prevent client modification.
     */
    @Schema(accessMode = Schema.AccessMode.READ_ONLY, description = "Timestamp when the schedule was last updated")
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private LocalDateTime updatedAt;
}