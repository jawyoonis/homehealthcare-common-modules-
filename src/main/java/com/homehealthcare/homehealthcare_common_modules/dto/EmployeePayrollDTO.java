package com.homehealthcare.homehealthcare_common_modules.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Schema(description = "Data Transfer Object for Employee Payroll information")
public class EmployeePayrollDTO {

    @Schema(description = "Unique identifier of the employee payroll record", accessMode = Schema.AccessMode.READ_ONLY)
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Long id;

    @Schema(description = "Unique identifier of the employee", example = "102")
    private Long employeeId;

    @Schema(description = "Unique identifier of the client", example = "101")
    private Long clientId;

    @Schema(description = "Unique identifier of the payroll period", example = "404")
    private Long payrollPeriodId;

    @Schema(description = "Unique identifier of the job associated with the payroll", example = "303")
    private Long jobId;

    @Schema(type = "string", format = "date", example = "2024-09-23", description = "Date of the employee payroll")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate payrollDate;

    @Schema(description = "Total hours worked by the employee during the payroll period", example = "40.0")
    private Double totalHours;

    @Schema(description = "Total amount payable to the employee", example = "2000.00")
    private Double totalAmount;

    @Schema(accessMode = Schema.AccessMode.READ_ONLY, description = "Timestamp when the payroll record was created")
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private LocalDateTime createdAt;

    @Schema(accessMode = Schema.AccessMode.READ_ONLY, description = "Timestamp when the payroll record was last updated")
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private LocalDateTime updatedAt;
}