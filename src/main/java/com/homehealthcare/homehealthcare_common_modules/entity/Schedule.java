package com.homehealthcare.homehealthcare_common_modules.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "schedules")
public class Schedule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "client_id", nullable = false)
    private Client client;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "employee_id", nullable = false)
    private Employee employee;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "replacement_employee_id")
    private Employee replacementEmployee;

    // Day-specific hours
    @Column(name = "monday_hours")
    private Double mondayHours;
    @Column(name = "tuesday_hours")
    private Double tuesdayHours;
    @Column(name = "wednesday_hours")
    private Double wednesdayHours;
    @Column(name = "thursday_hours")
    private Double thursdayHours;
    @Column(name = "friday_hours")
    private Double fridayHours;
    @Column(name = "saturday_hours")
    private Double saturdayHours;
    @Column(name = "sunday_hours")
    private Double sundayHours;
    @Column(name = "schedule_date")
    private LocalDate scheduleDate;

    // Day-specific clock-in and clock-out times
    @Column(name = "monday_clocked_in_time")
    private LocalTime mondayClockedInTime;
    @Column(name = "monday_clocked_out_time")
    private LocalTime mondayClockedOutTime;

    @Column(name = "tuesday_clocked_in_time")
    private LocalTime tuesdayClockedInTime;
    @Column(name = "tuesday_clocked_out_time")
    private LocalTime tuesdayClockedOutTime;

    @Column(name = "wednesday_clocked_in_time")
    private LocalTime wednesdayClockedInTime;
    @Column(name = "wednesday_clocked_out_time")
    private LocalTime wednesdayClockedOutTime;

    @Column(name = "thursday_clocked_in_time")
    private LocalTime thursdayClockedInTime;
    @Column(name = "thursday_clocked_out_time")
    private LocalTime thursdayClockedOutTime;

    @Column(name = "friday_clocked_in_time")
    private LocalTime fridayClockedInTime;
    @Column(name = "friday_clocked_out_time")
    private LocalTime fridayClockedOutTime;

    @Column(name = "saturday_clocked_in_time")
    private LocalTime saturdayClockedInTime;
    @Column(name = "saturday_clocked_out_time")
    private LocalTime saturdayClockedOutTime;

    @Column(name = "sunday_clocked_in_time")
    private LocalTime sundayClockedInTime;
    @Column(name = "sunday_clocked_out_time")
    private LocalTime sundayClockedOutTime;

    @Column(name = "status")
    private String status;

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
