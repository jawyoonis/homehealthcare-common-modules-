package com.homehealthcare.homehealthcare_common_modules.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(description = "Data Transfer Object for Employee Individual Permission")
public class EmployeeIndividualPermissionDTO {

    @Schema(description = "Unique identifier of the permission", example = "10")
    private Long permissionId;

    @Schema(description = "Type of the permission enum", example = "EMPLOYEE_MANAGEMENT")
    private String permissionType;

    @Schema(description = "Permission to read", example = "true")
    private Boolean canRead;

    @Schema(description = "Permission to write", example = "false")
    private Boolean canWrite;

    @Schema(description = "Permission to delete", example = "true")
    private Boolean canDelete;
}