package com.homehealthcare.homehealthcare_common_modules.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Schema(description = "Data Transfer Object for Scheduled Job information")
public class ScheduledJobDTO {

    @Schema(description = "Unique identifier of the scheduled job", accessMode = Schema.AccessMode.READ_ONLY)
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Long id;

    @Schema(description = "Type of the job", example = "Maintenance, Payroll Processing, Data Backup")
    private String jobType;

    @Schema(description = "Current status of the job", example = "Scheduled, In Progress, Completed, Failed")
    private String status;

    @Schema(type = "string", format = "date-time", description = "The time the job is scheduled to run", example = "2024-09-23T10:15:30")
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private LocalDateTime scheduledTime;

    @Schema(type = "string", format = "date-time", description = "The time the job was completed", example = "2024-09-23T12:30:45", nullable = true)
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private LocalDateTime completedTime;
}