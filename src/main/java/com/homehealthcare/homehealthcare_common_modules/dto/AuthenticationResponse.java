package com.homehealthcare.homehealthcare_common_modules.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor // Generates a constructor with arguments for all fields
public class AuthenticationResponse {
    private String token;
    private Long userId;
}
