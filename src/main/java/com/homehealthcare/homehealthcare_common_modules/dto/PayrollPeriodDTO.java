package com.homehealthcare.homehealthcare_common_modules.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Schema(description = "Data Transfer Object for Payroll Period information")
public class PayrollPeriodDTO {

    @Schema(description = "Unique identifier of the payroll period", accessMode = Schema.AccessMode.READ_ONLY)
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Long id;

    @Schema(description = "Name of the payroll period", example = "Q1-2024 Payroll")
    private String periodName;

    @Schema(description = "Year of the payroll period", example = "2024")
    private Integer year;

    @Schema(description = "Cycle of the payroll period (e.g., weekly, bi-weekly, monthly)", example = "bi-weekly")
    private String cycle;

    @Schema(type = "string", format = "date", description = "Start date of the payroll period", example = "2024-01-01")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate startDate;

    @Schema(type = "string", format = "date", description = "End date of the payroll period", example = "2024-01-15")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate endDate;

    @Schema(description = "Indicates whether the payroll period is finalized", example = "true")
    private Boolean finalized;

    @Schema(accessMode = Schema.AccessMode.READ_ONLY, description = "Timestamp when the payroll period record was created")
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private LocalDateTime createdAt;

    @Schema(accessMode = Schema.AccessMode.READ_ONLY, description = "Timestamp when the payroll period record was last updated")
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private LocalDateTime updatedAt;
}