// src/main/java/com/homecare/management/dto/CacheConfigDTO.java
package com.homehealthcare.homehealthcare_common_modules.dto;

import lombok.Value;

/**
 * DTO representing cache configuration settings
 */
@Value
public class CacheConfigDTO {
    long geocodingMaxSize;
    long geocodingExpireHours;
    long autocompleteMaxSize;
    long autocompleteExpireHours;
}