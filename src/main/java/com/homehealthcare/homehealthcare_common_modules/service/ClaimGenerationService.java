package com.homehealthcare.homehealthcare_common_modules.service;

import com.homehealthcare.homehealthcare_common_modules.Exceptions.ResourceNotFoundException;
import com.homehealthcare.homehealthcare_common_modules.Exceptions.ValidationException;
import com.homehealthcare.homehealthcare_common_modules.entity.Claim;
import com.homehealthcare.homehealthcare_common_modules.enums.ClaimStatus;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;
import java.util.List;

public interface ClaimGenerationService {
    /**
     * Generates claims from payroll data for a specific client and date range
     *
     * @param clientId   The ID of the client
     * @param startDate  Start of the period for claim generation
     * @param endDate    End of the period for claim generation
     * @return List of generated claims
     * @throws ResourceNotFoundException if client not found
     * @throws ValidationException if:
     *         - date range is invalid
     *         - no payroll records found
     *         - no valid payroll records in date range
     *         - claim generation fails
     */
    List<Claim> generateClaimsFromPayroll(
            @NotNull Long clientId,
            @NotNull LocalDateTime startDate,
            @NotNull LocalDateTime endDate);

    /**
     * Submits a claim for processing
     *
     * @param claimId The ID of the claim to submit
     * @throws ResourceNotFoundException if claim not found
     * @throws ValidationException if:
     *         - claim is not in submittable state
     *         - submission process fails
     */
    void submitClaim(@NotNull Long claimId);

    /**
     * Updates the status of a claim
     *
     * @param claimId          The ID of the claim to update
     * @param newStatus        The new status to set
     * @param rejectionReason  Reason for rejection (required when status is REJECTED)
     * @throws ResourceNotFoundException if claim not found
     * @throws ValidationException if:
     *         - status transition is invalid
     *         - rejection reason is missing when required
     *         - status update process fails
     *         - new status is null
     */
    void updateClaimStatus(
            @NotNull Long claimId,
            @NotNull ClaimStatus newStatus,
            String rejectionReason);

    /**
     * Gets claims within a date range
     *
     * @param startDate Start of the period
     * @param endDate End of the period
     * @return List of claims within the date range
     */
    List<Claim> getClaimsByDateRange(
            @NotNull LocalDateTime startDate,
            @NotNull LocalDateTime endDate);

    /**
     * Gets all claims for a specific client
     *
     * @param clientId The ID of the client
     * @return List of claims for the client
     */
    List<Claim> getClaimsByClient(@NotNull Long clientId);
}