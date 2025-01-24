package com.homehealthcare.homehealthcare_common_modules.dto;

import lombok.Data;

@Data
public class CoordinatesDTO {
    private Double latitude;
    private Double longitude;

    // Add this constructor
    public CoordinatesDTO(Double latitude, Double longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
    }

    // Default constructor (required for frameworks like Jackson)
    public CoordinatesDTO() {
    }
}