package com.homehealthcare.homehealthcare_common_modules.service;

import com.homehealthcare.homehealthcare_common_modules.dto.ClientPayrollDTO;

import java.util.List;

public interface ClientPayrollService {
    ClientPayrollDTO createClientPayroll(ClientPayrollDTO clientPayrollDTO);
    ClientPayrollDTO getClientPayrollById(Long id);
    List<ClientPayrollDTO> getAllClientPayrolls();
    ClientPayrollDTO updateClientPayroll(Long id, ClientPayrollDTO clientPayrollDTO);
    void deleteClientPayroll(Long id);
}