package com.homehealthcare.homehealthcare_common_modules.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.homehealthcare.homehealthcare_common_modules.enums.PermissionType;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Schema(description = "Data Transfer Object for Employee Type Permission")
public class EmployeeTypePermissionDTO {

    @Schema(description = "Unique identifier of the employee type permission", accessMode = Schema.AccessMode.READ_ONLY)
    private Long id;

    @Schema(description = "Unique identifier of the employee type", example = "1")
    private Long employeeTypeId;

    @Schema(description = "Unique identifier of the permission", example = "10")
    private Long permissionId;

    @Schema(description = "Type of the permission enum", example = "EMPLOYEE")
    private PermissionType permissionType;

    @Schema(description = "Permission to read", example = "true")
    private Boolean canRead;

    @Schema(description = "Permission to write", example = "false")
    private Boolean canWrite;

    @Schema(description = "Permission to delete", example = "true")
    private Boolean canDelete;

    @Schema(description = "Timestamp when the permission was created", accessMode = Schema.AccessMode.READ_ONLY)
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private LocalDateTime createdAt;

    @Schema(description = "Timestamp when the permission was last updated", accessMode = Schema.AccessMode.READ_ONLY)
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private LocalDateTime updatedAt;
}
