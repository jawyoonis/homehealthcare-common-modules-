package com.homehealthcare.homehealthcare_common_modules.service;

import com.homehealthcare.homehealthcare_common_modules.dto.EmployeeTypePermissionDTO;

import java.util.List;

public interface EmployeeTypePermissionService {
    EmployeeTypePermissionDTO findEmployeeTypePermissionById(Long employeeTypePermissionId);
    EmployeeTypePermissionDTO createEmployeeTypePermission(EmployeeTypePermissionDTO employeeTypePermissionDTO);
    EmployeeTypePermissionDTO updateEmployeeTypePermission(Long employeeTypePermissionId, EmployeeTypePermissionDTO employeeTypePermissionDTO);
    void deleteEmployeeTypePermission(Long employeeTypePermissionId);
    List<EmployeeTypePermissionDTO> getAllEmployeeTypePermissions();
    List<EmployeeTypePermissionDTO> findEmployeeTypePermissionsByEmployeeTypeId(Long employeeTypeId);
    List<EmployeeTypePermissionDTO> findEmployeeTypePermissionsByPermissionId(Long permissionId);
}