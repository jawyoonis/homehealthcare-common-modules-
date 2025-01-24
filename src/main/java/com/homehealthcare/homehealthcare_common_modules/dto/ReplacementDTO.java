package com.homehealthcare.homehealthcare_common_modules.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Schema(description = "Replacement Data Transfer Object")
public class ReplacementDTO {

    @Schema(description = "ID of the replacement", accessMode = Schema.AccessMode.READ_ONLY)
    private Long id;

    @Schema(description = "ID of the original caregiver", example = "1538")
    private Long originalCaregiverId;

    @Schema(description = "ID of the replacement caregiver", example = "1539")
    private Long replacementCaregiverId;

    @Schema(description = "ID of the client", example = "871")
    private Long clientId;

    @Schema(description = "Start date of the replacement", example = "2024-09-22")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate replacementStartDate;

    @Schema(description = "End date of the replacement", example = "2024-09-22")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate replacementEndDate;

    @Schema(description = "Creation timestamp", accessMode = Schema.AccessMode.READ_ONLY)
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private LocalDateTime createdAt;

    @Schema(description = "Last updated timestamp", accessMode = Schema.AccessMode.READ_ONLY)
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private LocalDateTime updatedAt;
}
