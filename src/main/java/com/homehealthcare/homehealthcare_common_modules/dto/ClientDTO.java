package com.homehealthcare.homehealthcare_common_modules.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import java.time.LocalDateTime;

@Data
@Schema(description = "Data Transfer Object for Client information")
public class ClientDTO {

    @Schema(description = "Unique identifier of the client", accessMode = Schema.AccessMode.READ_ONLY)
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Long clientId;

    @Schema(description = "Unique identifier number for the client", example = "CL12345")
    private String idNumber;

    @Schema(description = "First name of the client", example = "Joseph")
    private String firstName;

    @Schema(description = "Last name of the client", example = "Doe")
    private String lastName;

    @Schema(description = "Email address of the client", example = "joseph.doe@example.com")
    private String email;

    @Schema(description = "Birthday of the client", example = "1980-01-01")
    private String birthday;

    @Schema(description = "Reimbursement rate for the client", example = "25.50")
    private Double reimbursementRate;

    @Schema(description = "Address of the client", example = "123 Main St, Anytown, AN 12345")
    private String address;

    @Schema(description = "Latitude of the client's location", example = "40.7128")
    private Double latitude;

    @Schema(description = "Longitude of the client's location", example = "-74.0060")
    private Double longitude;

    @Schema(description = "Zipcode of the client's address", example = "12345")
    private String zipcode;

    @Schema(accessMode = Schema.AccessMode.READ_ONLY, description = "Timestamp when the client was created")
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private LocalDateTime createdAt;

    @Schema(accessMode = Schema.AccessMode.READ_ONLY, description = "Timestamp when the client was last updated")
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private LocalDateTime updatedAt;
}