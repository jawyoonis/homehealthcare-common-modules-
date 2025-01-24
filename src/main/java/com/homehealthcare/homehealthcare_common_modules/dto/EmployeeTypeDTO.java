package com.homehealthcare.homehealthcare_common_modules.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.Set;

@Data
@Schema(description = "Data Transfer Object for Employee Type")
public class EmployeeTypeDTO {

    @Schema(description = "Unique identifier of the employee type", accessMode = Schema.AccessMode.READ_ONLY)
    private Long id;

    @Schema(description = "Name or type of the employee role", example = "Caregiver")
    private String type;

    @Schema(description = "Set of employee IDs associated with this employee type", example = "[1, 2, 3]", hidden = true)
    private Set<Long> employeeIds;

    @Schema(description = "Set of permission IDs associated with this employee type", example = "[10, 20, 30]", hidden = true)
    private Set<Long> permissionIds;

    @Schema(description = "Set of permissions with flags assigned to this employee type")
    private Set<EmployeeTypePermissionDTO> permissions;

    @Schema(accessMode = Schema.AccessMode.READ_ONLY, description = "Timestamp when the payroll type record was created")
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private LocalDateTime createdAt;

    @Schema(accessMode = Schema.AccessMode.READ_ONLY, description = "Timestamp when the payroll type record was last updated")
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private LocalDateTime updatedAt;
}
