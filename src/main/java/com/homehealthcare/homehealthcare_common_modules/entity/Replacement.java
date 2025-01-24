package com.homehealthcare.homehealthcare_common_modules.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "replacements")
public class Replacement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Original caregiver (employee being replaced)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "original_caregiver_id", nullable = false)
    private Employee originalCaregiver;

    // Replacement caregiver (employee stepping in)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "replacement_caregiver_id", nullable = false)
    private Employee replacementCaregiver;

    // Client receiving care
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "client_id", nullable = false)
    private Client client;

    @Column(name = "replacement_start_date", nullable = false)
    private LocalDate replacementStartDate;

    @Column(name = "replacement_end_date")
    private LocalDate replacementEndDate;

    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @PrePersist
    protected void onCreate() {
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
    }

    @PreUpdate
    protected void onUpdate() {
        this.updatedAt = LocalDateTime.now();
    }
}
