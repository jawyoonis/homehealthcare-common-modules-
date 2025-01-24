package com.homehealthcare.homehealthcare_common_modules.entity;

import com.homehealthcare.homehealthcare_common_modules.enums.DeviceType;
import com.homehealthcare.homehealthcare_common_modules.enums.OperatingSystem;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "device_info")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DeviceInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Enumerated(EnumType.STRING)
    private DeviceType deviceType; // Enum field for device type

    @Enumerated(EnumType.STRING)
    private OperatingSystem osVersion; // Enum field for Operating System

    private String appVersion;
    private String deviceId;

    // Getters and Setters
}