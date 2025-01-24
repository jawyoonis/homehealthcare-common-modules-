package com.homehealthcare.homehealthcare_common_modules.dto;

import lombok.Data;

@Data
public class AddressDTO {
    private String formattedAddress;
    private Double latitude;
    private Double longitude;
    private String zipCode;
}