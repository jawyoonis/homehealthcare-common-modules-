package com.homehealthcare.homehealthcare_common_modules.entity;

import com.homehealthcare.homehealthcare_common_modules.enums.VerificationMethod;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "evv_visit_timesheet")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class EVVVisitTimesheet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "clientId", nullable = false)
    private Client client;

    @ManyToOne
    @JoinColumn(name = "caregiverId", nullable = false)
    private Employee caregiver;

    @ManyToOne
    @JoinColumn(name = "schedule_id", nullable = false)
    private Schedule schedule;

    @Column(name = "actual_clocked_in_time", nullable = false)
    private LocalDateTime actualClockedInTime;

    @Column(name = "actual_clocked_out_time")
    private LocalDateTime actualClockedOutTime;

    @Column(name = "total_hours_worked")
    private Double totalHoursWorked;

    @Column(name = "is_late", nullable = false)
    private boolean isLate;

    @Column(name = "delay_minutes")
    private int delayMinutes;

    @Column(name = "clocked_in_latitude", nullable = false)
    private double clockedInLatitude;

    @Column(name = "clocked_in_longitude", nullable = false)
    private double clockedInLongitude;

    @Column(name = "clocked_out_latitude")
    private Double clockedOutLatitude;

    @Column(name = "clocked_out_longitude")
    private Double clockedOutLongitude;

    @ManyToOne
    @JoinColumn(name = "clock_in_device_info_id")
    private DeviceInfo clockInDeviceInfo;

    @ManyToOne
    @JoinColumn(name = "clock_out_device_info_id")
    private DeviceInfo clockOutDeviceInfo;

    @Column(name = "notes")
    private String notes;

    @Enumerated(EnumType.STRING)
    @Column(name = "verification_method")
    private VerificationMethod verificationMethod;

    @Column(name = "service_type")
    private String serviceType;

    @Column(name = "status")
    private String status;

    @Column(name = "verified")
    private boolean verified;

    // Method to determine if the timesheet is verified using the enum's logic
    public boolean isVerified() {
        return verificationMethod != null && verificationMethod.isVerified();
    }
}