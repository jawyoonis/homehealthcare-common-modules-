package com.homehealthcare.homehealthcare_common_modules.service;


import com.homehealthcare.homehealthcare_common_modules.dto.EVVVisitTimesheetDTO;
import com.homehealthcare.homehealthcare_common_modules.entity.Client;

public interface ClientPayrollUpdateService {
    /**
     * Updates the client payroll record when a caregiver clocks out.
     * This method will either create a new payroll record or update an existing one
     * for the current pay period.
     *
     * @param timesheetDTO The timesheet data containing clock out information
     * @param client The client whose payroll needs to be updated
     */
    void updateClientPayrollOnClockOut(EVVVisitTimesheetDTO timesheetDTO, Client client);
}