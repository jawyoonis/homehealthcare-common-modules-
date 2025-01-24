package com.homehealthcare.homehealthcare_common_modules.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.*;
import lombok.Data;
import java.time.LocalDateTime;

@Data
@Schema(description = "Data Transfer Object for Claims")
public class ClaimDTO {
    @Schema(description = "Unique identifier of the claim", accessMode = Schema.AccessMode.READ_ONLY)
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Long id;

    @Schema(description = "ID of the client this claim belongs to", example = "1")
    @NotNull(message = "Client ID is required")
    private Long clientId;

    @Schema(description = "Unique claim number", example = "CLM-12345ABC")
    @Pattern(regexp = "CLM-[A-Z0-9]{8}", message = "Claim number must be in format CLM-XXXXXXXX")
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private String claimNumber;

    @Schema(description = "Start date of service period", example = "2024-01-01T00:00:00")
    @NotNull(message = "Service start date is required")
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private LocalDateTime serviceStartDate;

    @Schema(description = "End date of service period", example = "2024-01-31T23:59:59")
    @NotNull(message = "Service end date is required")
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private LocalDateTime serviceEndDate;

    @Schema(description = "Total hours of service", example = "160.5")
    @NotNull(message = "Total hours is required")
    @PositiveOrZero(message = "Total hours must be zero or positive")
    private Double totalHours;

    @Schema(description = "Total amount to be claimed", example = "2400.75")
    @NotNull(message = "Total amount is required")
    @PositiveOrZero(message = "Total amount must be zero or positive")
    private Double totalAmount;

    @Schema(description = "Current status of the claim", example = "DRAFT")
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private String status;

    @Schema(description = "Date when claim was submitted", example = "2024-01-31T12:00:00")
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private LocalDateTime submissionDate;

    @Schema(description = "Reason for rejection if claim was rejected")
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private String rejectionReason;

    @Schema(description = "Timestamp when claim was created", accessMode = Schema.AccessMode.READ_ONLY)
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private LocalDateTime createdAt;

    @Schema(description = "Timestamp when claim was last updated", accessMode = Schema.AccessMode.READ_ONLY)
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private LocalDateTime updatedAt;
}