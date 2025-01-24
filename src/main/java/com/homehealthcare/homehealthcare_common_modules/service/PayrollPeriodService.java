package com.homehealthcare.homehealthcare_common_modules.service;

import com.homehealthcare.homehealthcare_common_modules.dto.PayrollPeriodDTO;

import java.util.List;

public interface PayrollPeriodService {
    PayrollPeriodDTO createPayrollPeriod(PayrollPeriodDTO payrollPeriodDTO);
    PayrollPeriodDTO getPayrollPeriodById(Long id);
    List<PayrollPeriodDTO> getAllPayrollPeriods();
    PayrollPeriodDTO updatePayrollPeriod(Long id, PayrollPeriodDTO payrollPeriodDTO);
    void deletePayrollPeriod(Long id);
}