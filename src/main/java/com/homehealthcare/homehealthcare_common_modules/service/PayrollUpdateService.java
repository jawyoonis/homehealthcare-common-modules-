package com.homehealthcare.homehealthcare_common_modules.service;

import com.homehealthcare.homehealthcare_common_modules.dto.EVVVisitTimesheetDTO;
import com.homehealthcare.homehealthcare_common_modules.entity.Employee;

public interface PayrollUpdateService {
    /**
     * Updates the employee payroll record when they clock out from a shift.
     * This method will either create a new payroll record or update an existing one
     * for the current pay period.
     *
     * @param timesheetDTO The timesheet data containing clock out information
     * @param employee The employee whose payroll needs to be updated
     */
    void updatePayrollOnClockOut(EVVVisitTimesheetDTO timesheetDTO, Employee employee);
}