package com.homehealthcare.homehealthcare_common_modules.service;

import com.homehealthcare.homehealthcare_common_modules.dto.EVVVisitTimesheetDTO;
import com.homehealthcare.homehealthcare_common_modules.enums.VerificationMethod;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface EVVVisitTimesheetService {

    // Basic CRUD Methods

    /**
     * Retrieves all EVVVisitTimesheets.
     * @return List of all EVVVisitTimesheets
     */
    List<EVVVisitTimesheetDTO> getAllVisitTimesheets();

    /**
     * Retrieves an EVVVisitTimesheet by its ID.
     * @param id The ID of the timesheet
     * @return The EVVVisitTimesheet, or Optional.empty if not found
     */
    Optional<EVVVisitTimesheetDTO> getVisitTimesheetById(int id);

    /**
     * Clock-in operation for creating a new EVVVisitTimesheet with clock-in information.
     * @param timesheet The EVVVisitTimesheet to be saved with clock-in details
     * @return The saved EVVVisitTimesheet
     */
    EVVVisitTimesheetDTO clockIn(EVVVisitTimesheetDTO timesheet);

    /**
     * Clock-out operation for updating an existing EVVVisitTimesheet with clock-out information,
     * identified by clientId, caregiverId, and actualClockedInDate.
     * @param clientId The ID of the client
     * @param caregiverId The ID of the caregiver
     * @param actualClockedInDate The date of the clock-in time for the timesheet
     * @param timesheet The EVVVisitTimesheet with clock-out details
     * @return The updated EVVVisitTimesheet
     */
    EVVVisitTimesheetDTO clockOut(Long clientId, Long caregiverId, LocalDateTime actualClockedInDate, EVVVisitTimesheetDTO timesheet);

    /**
     * Deletes an EVVVisitTimesheet by its ID.
     * @param id The ID of the timesheet to delete
     */
    void deleteVisitTimesheet(int id);

    // Additional Methods

    /**
     * Retrieves all EVVVisitTimesheets for a specific client by client ID.
     * @param clientId The ID of the client
     * @return List of EVVVisitTimesheets for the specified client
     */
    List<EVVVisitTimesheetDTO> getVisitTimesheetsByClientId(Long clientId);

    /**
     * Retrieves all EVVVisitTimesheets for a specific caregiver by caregiver ID.
     * @param caregiverId The ID of the caregiver
     * @return List of EVVVisitTimesheets for the specified caregiver
     */
    List<EVVVisitTimesheetDTO> getVisitTimesheetsByCaregiverId(Long caregiverId);

    /**
     * Retrieves all EVVVisitTimesheets for a specific schedule by schedule ID.
     * @param scheduleId The ID of the schedule
     * @return List of EVVVisitTimesheets for the specified schedule
     */
    List<EVVVisitTimesheetDTO> getVisitTimesheetsByScheduleId(Long scheduleId);

    /**
     * Retrieves all EVVVisitTimesheets within a date range.
     * @param startDate The start of the date range
     * @param endDate The end of the date range
     * @return List of EVVVisitTimesheets within the specified date range
     */
    List<EVVVisitTimesheetDTO> getVisitTimesheetsByDateRange(LocalDateTime startDate, LocalDateTime endDate);

    /**
     * Retrieves the total hours worked by a specific caregiver within a date range.
     * @param caregiverId The ID of the caregiver
     * @param startDate The start of the date range
     * @param endDate The end of the date range
     * @return The total hours worked by the caregiver within the date range
     */
    double getTotalHoursWorkedByCaregiver(Long caregiverId, LocalDateTime startDate, LocalDateTime endDate);

    /**
     * Retrieves all late EVVVisitTimesheets.
     * @return List of EVVVisitTimesheets where isLate is true
     */
    List<EVVVisitTimesheetDTO> getLateVisitTimesheets();

    /**
     * Retrieves all EVVVisitTimesheets where a specific verification method was used.
     * @param verificationMethod The verification method used
     * @return List of EVVVisitTimesheets where the verification method was used
     */
    List<EVVVisitTimesheetDTO> getVisitTimesheetsByVerificationMethod(VerificationMethod verificationMethod);

    /**
     * Retrieves the total hours worked by all caregivers within a date range.
     * @param startDate The start of the date range
     * @param endDate The end of the date range
     * @return The total hours worked by all caregivers within the date range
     */
    double getTotalHoursWorkedByAllCaregivers(Long caregiverId, LocalDateTime startDate, LocalDateTime endDate);

    /**
     * Retrieves all EVVVisitTimesheets for a specific client and caregiver.
     * @param clientId The ID of the client
     * @param caregiverId The ID of the caregiver
     * @return List of EVVVisitTimesheets for the specified client and caregiver
     */
    List<EVVVisitTimesheetDTO> getVisitTimesheetsByClientAndCaregiver(Long clientId, Long caregiverId);

    /**
     * Checks if a specific EVVVisitTimesheet has been verified.
     * @param id The ID of the timesheet
     * @return true if the timesheet is verified, false otherwise
     */
    boolean isVisitTimesheetVerified(int id);

    /**
     * Retrieves all EVVVisitTimesheets for a specific client and schedule.
     * @param clientId The ID of the client
     * @param scheduleId The ID of the schedule
     * @return List of EVVVisitTimesheets for the specified client and schedule
     */
    List<EVVVisitTimesheetDTO> findTimesheetsByClientAndSchedule(Long clientId, long scheduleId);

    /**
     * Retrieves all EVVVisitTimesheets where the total hours worked is greater than a specific value.
     * @param hoursWorked The minimum total hours worked
     * @return List of EVVVisitTimesheets where the total hours worked is greater than the specified value
     */
    List<EVVVisitTimesheetDTO> findTimesheetsByTotalHoursWorkedGreaterThan(Long hoursWorked);

    List<EVVVisitTimesheetDTO> getTodaysShiftsByCaregiver(Long caregiverId);


}

