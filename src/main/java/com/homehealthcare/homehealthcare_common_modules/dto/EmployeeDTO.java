package com.homehealthcare.homehealthcare_common_modules.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.Set;

@Data
@Schema(description = "Data Transfer Object for Employee information")
public class EmployeeDTO {

    @Schema(description = "Unique identifier of the employee", accessMode = Schema.AccessMode.READ_ONLY)
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Long id;

    @Schema(description = "First name of the employee", example = "Jane")
    private String firstName;

    @Schema(description = "Last name of the employee", example = "Smith")
    private String lastName;

    @Schema(description = "Birthday of the employee", example = "1985-05-15")
    private String birthday;

    @Schema(description = "Hourly rate for the employee", example = "25.50")
    private Double ratePerHour;

    @Schema(description = "Username for the employee", example = "jsmith")
    private String username;

    @Schema(description = "Email address of the employee", example = "jane.smith@example.com")
    private String email;

    @Schema(description = "Zipcode of the employee's address", example = "12345")
    private String zipcode;

    @Schema(description = "Address of the employee", example = "456 Oak St, Anytown, AN 12345")
    private String address;

    @Schema(description = "Latitude of the employee's location", example = "40.7128")
    private Double latitude;

    @Schema(description = "Longitude of the employee's location", example = "-74.0060")
    private Double longitude;

    @Schema(description = "ID of the employee's type (role)", example = "1")
    private Long employeeTypeId;

    @Schema(description = "Set of individual permissions for the employee")
    private Set<EmployeeIndividualPermissionDTO> individualPermissions;

    @Schema(accessMode = Schema.AccessMode.READ_ONLY, description = "Timestamp when the employee was created")
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private LocalDateTime createdAt;

    @Schema(accessMode = Schema.AccessMode.READ_ONLY, description = "Timestamp when the employee was last updated")
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private LocalDateTime updatedAt;
}