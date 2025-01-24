//package com.homehealthcare.homehealthcare_common_modules.mappers;
//
//import com.homehealthcare.homehealthcare_common_modules.dto.EmployeePayrollDTO;
//import com.homehealthcare.homehealthcare_common_modules.entity.EmployeePayroll;
//import org.mapstruct.*;
//
//@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
//public interface EmployeePayrollMapper {
//
//    @Mapping(target = "employeeId", source = "employee.id")
//    @Mapping(target = "clientId", source = "client.clientId")
//    @Mapping(target = "payrollPeriodId", source = "payrollPeriod.id")
//    EmployeePayrollDTO employeePayrollToEmployeePayrollDTO(EmployeePayroll employeePayroll);
//
//    @Mapping(target = "employee", ignore = true)
//    @Mapping(target = "client", ignore = true)
//    @Mapping(target = "payrollPeriod", ignore = true)
//    EmployeePayroll employeePayrollDTOToEmployeePayroll(EmployeePayrollDTO employeePayrollDTO);
//
//    @Mapping(target = "id", ignore = true)
//    @Mapping(target = "employee", ignore = true)
//    @Mapping(target = "client", ignore = true)
//    @Mapping(target = "payrollPeriod", ignore = true)
//    void updateEmployeePayrollFromDTO(EmployeePayrollDTO employeePayrollDTO, @MappingTarget EmployeePayroll employeePayroll);
//}