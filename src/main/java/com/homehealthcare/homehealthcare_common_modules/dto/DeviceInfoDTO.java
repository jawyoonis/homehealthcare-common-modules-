package com.homehealthcare.homehealthcare_common_modules.dto;

import com.homehealthcare.homehealthcare_common_modules.enums.DeviceType;
import com.homehealthcare.homehealthcare_common_modules.enums.OperatingSystem;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(description = "Data Transfer Object for Device Information")
public class DeviceInfoDTO {

    @Schema(description = "Unique identifier for the device info", accessMode = Schema.AccessMode.READ_ONLY)
    private int id;

    @Schema(description = "Type of device used", example = "PHONE", allowableValues = {"DESKTOP", "TABLET", "PHONE", "LAPTOP", "SMARTWATCH", "OTHER"})
    private DeviceType deviceType;

    @Schema(description = "Operating system of the device", example = "ANDROID", allowableValues = {"ANDROID", "IOS", "WINDOWS", "LINUX"})
    private OperatingSystem osVersion;

    @Schema(description = "Version of the EVV application", example = "2.1.0")
    private String appVersion;

    @Schema(description = "Unique identifier of the device", example = "89ABCDEF-01234567")
    private String deviceId;
}