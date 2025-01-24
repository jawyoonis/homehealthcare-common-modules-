package com.homehealthcare.homehealthcare_common_modules.service;

import com.homehealthcare.homehealthcare_common_modules.dto.EmployeeDTO;
import com.homehealthcare.homehealthcare_common_modules.dto.EmployeeIndividualPermissionDTO;
import com.homehealthcare.homehealthcare_common_modules.dto.GeoRangeDTO;
import java.util.List;

public interface EmployeeService {
    EmployeeDTO findEmployeeById(Long employeeId);
    EmployeeDTO findEmployeeByUsername(String username);
    EmployeeDTO createEmployee(EmployeeDTO employeeDTO);
    EmployeeDTO updateEmployee(Long employeeId, EmployeeDTO employeeDTO);
    void deleteEmployee(Long employeeId);
    void deleteEmployees(List<Long> employeeIds);
    List<EmployeeDTO> getAllEmployees();
    EmployeeDTO findEmployeeByLastName(String lastName);
    EmployeeDTO findEmployeeByFirstName(String firstName);
    EmployeeDTO findEmployeeByEmail(String email);
    List<EmployeeDTO> findEmployeesByAddress(String address);
    List<EmployeeDTO> findEmployeesByZipcode(String zipcode);
    List<EmployeeDTO> findEmployeesInGeoRange(GeoRangeDTO geoRangeDTO);
    List<EmployeeDTO> findEmployeesByRateGreaterThan(Double rate);
    EmployeeDTO assignRolesToEmployee(Long employeeId, List<Long> roleIds);
    EmployeeDTO assignPermissionsToEmployee(Long employeeId, List<EmployeeIndividualPermissionDTO> permissionDTOs);
}