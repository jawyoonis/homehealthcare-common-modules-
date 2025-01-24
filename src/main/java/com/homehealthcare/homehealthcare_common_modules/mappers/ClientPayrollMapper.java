//package com.homehealthcare.homehealthcare_common_modules.mappers;
//
//import com.homehealthcare.homehealthcare_common_modules.dto.ClientPayrollDTO;
//import com.homehealthcare.homehealthcare_common_modules.entity.ClientPayroll;
//import org.mapstruct.*;
//
//@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
//public interface ClientPayrollMapper {
//
//    @Mapping(target = "clientId", source = "client.clientId")
//    @Mapping(target = "jobId", source = "job.id")
//    @Mapping(target = "payrollPeriodId", source = "payrollPeriod.id")
//    ClientPayrollDTO clientPayrollToClientPayrollDTO(ClientPayroll clientPayroll);
//
//    @Mapping(target = "client", ignore = true)
//    @Mapping(target = "job", ignore = true)
//    @Mapping(target = "payrollPeriod", ignore = true)
//    ClientPayroll clientPayrollDTOToClientPayroll(ClientPayrollDTO clientPayrollDTO);
//
//    @Mapping(target = "id", ignore = true)
//    @Mapping(target = "client", ignore = true)
//    @Mapping(target = "job", ignore = true)
//    @Mapping(target = "payrollPeriod", ignore = true)
//    @Mapping(target = "createdAt", ignore = true)
//    void updateClientPayrollFromDTO(ClientPayrollDTO clientPayrollDTO, @MappingTarget ClientPayroll clientPayroll);
//}