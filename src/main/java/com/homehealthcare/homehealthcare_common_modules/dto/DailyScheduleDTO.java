package com.homehealthcare.homehealthcare_common_modules.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Data
@Schema(description = "Data Transfer Object for daily schedule information")
public class DailyScheduleDTO {
    @Schema(description = "Unique identifier of the schedule")
    private Long id;

    private Long clientId;
    @Schema(description = "Client's first name")
    private String clientFirstName;
    @Schema(description = "Client's last name")
    private String clientLastName;

    private Long employeeId;
    @Schema(description = "Employee's first name")
    private String employeeFirstName;
    @Schema(description = "Employee's last name")
    private String employeeLastName;

    private Long replacementEmployeeId;
    @Schema(description = "Replacement employee's first name")
    private String replacementEmployeeFirstName;
    @Schema(description = "Replacement employee's last name")
    private String replacementEmployeeLastName;

    @Schema(description = "Hours scheduled for the day")
    private Double hours;

    @Schema(type = "string", format = "date", example = "2024-09-22")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate scheduleDate;

    @Schema(type = "string", format = "time", example = "09:00:00")
    @JsonFormat(pattern = "HH:mm:ss")
    private LocalTime clockedInTime;

    @Schema(type = "string", format = "time", example = "17:00:00")
    @JsonFormat(pattern = "HH:mm:ss")
    private LocalTime clockedOutTime;

    private String status;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}