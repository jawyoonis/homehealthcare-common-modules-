package com.homehealthcare.homehealthcare_common_modules.entity;
import com.homehealthcare.homehealthcare_common_modules.enums.ClaimStatus;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "claims",
        indexes = {
                @Index(name = "idx_claim_client", columnList = "client_id"),
                @Index(name = "idx_claim_status", columnList = "status"),
                @Index(name = "idx_claim_dates", columnList = "service_start_date, service_end_date")
        })
public class Claim {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "client_id", referencedColumnName = "client_id", nullable = false)
    private Client client;

    @NotNull
    @Column(name = "claim_number", unique = true, nullable = false)
    private String claimNumber;

    @NotNull
    @Column(name = "service_start_date", nullable = false)
    private LocalDateTime serviceStartDate;

    @NotNull
    @Column(name = "service_end_date", nullable = false)
    private LocalDateTime serviceEndDate;

    @NotNull
    @PositiveOrZero
    @Column(name = "total_hours", nullable = false)
    private Double totalHours;

    @NotNull
    @PositiveOrZero
    @Column(name = "total_amount", nullable = false)
    private Double totalAmount;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false)
    private ClaimStatus status;

    @Column(name = "submission_date")
    private LocalDateTime submissionDate;

    @Column(name = "rejection_reason")
    private String rejectionReason;

    @NotNull
    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @NotNull
    @UpdateTimestamp
    @Column(name = "updated_at", nullable = false)
    private LocalDateTime updatedAt;

    @Version
    @Column(name = "version")
    private Long version;

    @PrePersist
    protected void onCreate() {
        createdAt = LocalDateTime.now();
        updatedAt = LocalDateTime.now();

        // Validate dates
        if (serviceEndDate != null && serviceStartDate != null &&
                serviceEndDate.isBefore(serviceStartDate)) {
            throw new IllegalArgumentException("Service end date cannot be before service start date");
        }
    }

    @PreUpdate
    protected void onUpdate() {
        updatedAt = LocalDateTime.now();
    }

    // Business logic methods
    public boolean isEditable() {
        return status == ClaimStatus.DRAFT || status == ClaimStatus.REJECTED;
    }

    public boolean isSubmittable() {
        return status == ClaimStatus.DRAFT || status == ClaimStatus.REJECTED;
    }

    public boolean isResubmittable() {
        return status == ClaimStatus.REJECTED;
    }
}