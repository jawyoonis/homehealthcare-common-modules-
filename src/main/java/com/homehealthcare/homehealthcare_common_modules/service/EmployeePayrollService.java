package com.homehealthcare.homehealthcare_common_modules.service;

import com.homehealthcare.homehealthcare_common_modules.dto.EmployeePayrollDTO;

import java.util.List;

public interface EmployeePayrollService {
    EmployeePayrollDTO createPayroll(EmployeePayrollDTO payrollDTO);
    EmployeePayrollDTO getPayrollById(Long id);
    List<EmployeePayrollDTO> getAllPayrolls();
    EmployeePayrollDTO updatePayroll(Long id, EmployeePayrollDTO payrollDTO);
    void deletePayroll(Long id);
}