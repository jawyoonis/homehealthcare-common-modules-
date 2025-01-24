package com.homehealthcare.homehealthcare_common_modules.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Schema(description = "Data Transfer Object for displaying Schedule information")
public class ScheduleDisplayDTO {

    @Schema(description = "Unique identifier of the schedule", accessMode = Schema.AccessMode.READ_ONLY)
    private Long id;

    @Schema(description = "ID of the associated client", example = "871")
    private Long clientId;

    @Schema(description = "First name of the associated client")
    private String clientFirstName;

    @Schema(description = "Last name of the associated client")
    private String clientLastName;

    @Schema(description = "ID of the assigned employee", example = "1538")
    private Long employeeId;

    @Schema(description = "First name of the assigned employee")
    private String employeeFirstName;

    @Schema(description = "Last name of the assigned employee")
    private String employeeLastName;

    @Schema(description = "ID of the replacement employee, if assigned", nullable = true, example = "null")
    private Long replacementEmployeeId;

    @Schema(description = "First name of the replacement employee, if assigned")
    private String replacementEmployeeFirstName;

    @Schema(description = "Last name of the replacement employee, if assigned")
    private String replacementEmployeeLastName;

    @Schema(type = "string", format = "date", example = "2024-09-22", description = "Date of the schedule")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate scheduleDate;

    @Schema(description = "Clock-in time for the specific schedule date")
    private String clockedInTime;

    @Schema(description = "Clock-out time for the specific schedule date")
    private String clockedOutTime;

    @Schema(description = "Total hours for the specific schedule date")
    private Double hours;

    @Schema(description = "Current status of the schedule")
    private String status;

    @Schema(accessMode = Schema.AccessMode.READ_ONLY, description = "Timestamp when the schedule was created")
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private LocalDateTime createdAt;

    @Schema(accessMode = Schema.AccessMode.READ_ONLY, description = "Timestamp when the schedule was last updated")
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private LocalDateTime updatedAt;
}