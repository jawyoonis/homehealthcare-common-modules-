package com.homehealthcare.homehealthcare_common_modules.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data // Generates getters, setters, toString, equals, and hashCode methods
@NoArgsConstructor // Generates a no-argument constructor
@AllArgsConstructor // Generates a constructor with arguments for all fields
public class AuthenticationRequest {
    private String username;
    private String password;
}
