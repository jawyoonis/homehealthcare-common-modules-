package com.homehealthcare.homehealthcare_common_modules.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Schema(description = "Data Transfer Object for Client Payroll")
public class ClientPayrollDTO {

    @Schema(description = "Unique identifier of the client payroll record", accessMode = Schema.AccessMode.READ_ONLY)
    private Long id;

    @Schema(description = "Unique foreign key identifier of the client who the payroll entry belong to", example = "101")
    private Long clientId;

    @Schema(description = "Unique identifier of the claim", example = "202")
    private Long claimId;

    @Schema(description = "Unique identifier of the job associated with the payroll", example = "303")
    private Long jobId;

    @Schema(description = "Unique identifier of the payroll period", example = "404")
    private Long payrollPeriodId;

    @Schema(description = "Current date of the client payroll", example = "2024-09-23")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate currentClientPayrollDate;

    @Schema(description = "Start date of the payroll period", example = "2024-09-01")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private String startDate;

    @Schema(description = "End date of the payroll period", example = "2024-09-15")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private String endDate;

    @Schema(description = "Total hours worked during the payroll period", example = "40.0")
    private Double totalHours;

    @Schema(description = "Total amount payable to the client", example = "1000.50")
    private Double totalAmount;

    @Schema(accessMode = Schema.AccessMode.READ_ONLY, description = "Timestamp when the client payroll was created")
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private LocalDateTime createdAt;

    @Schema(accessMode = Schema.AccessMode.READ_ONLY, description = "Timestamp when the client payroll was last updated")
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private LocalDateTime updatedAt;
}