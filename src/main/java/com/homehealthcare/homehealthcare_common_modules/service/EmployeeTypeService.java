package com.homehealthcare.homehealthcare_common_modules.service;
import com.homehealthcare.homehealthcare_common_modules.dto.EmployeeTypeDTO;

import java.util.List;

public interface EmployeeTypeService {
    EmployeeTypeDTO findEmployeeTypeById(Long employeeTypeId);
    EmployeeTypeDTO findEmployeeTypeByType(String type);
    EmployeeTypeDTO createEmployeeType(EmployeeTypeDTO employeeTypeDTO);
    EmployeeTypeDTO updateEmployeeType(Long employeeTypeId, EmployeeTypeDTO employeeTypeDTO);
    void deleteEmployeeType(Long employeeTypeId);
    List<EmployeeTypeDTO> getAllEmployeeTypes();
}