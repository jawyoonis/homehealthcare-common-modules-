package com.homehealthcare.homehealthcare_common_modules.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(description = "Data Transfer Object for Geographic Range")
public class GeoRangeDTO {

    @Schema(description = "Minimum latitude for the geographic range", example = "40.7128")
    private Double minLat;

    @Schema(description = "Maximum latitude for the geographic range", example = "41.2033")
    private Double maxLat;

    @Schema(description = "Minimum longitude for the geographic range", example = "-74.0060")
    private Double minLong;

    @Schema(description = "Maximum longitude for the geographic range", example = "-73.9352")
    private Double maxLong;
}
