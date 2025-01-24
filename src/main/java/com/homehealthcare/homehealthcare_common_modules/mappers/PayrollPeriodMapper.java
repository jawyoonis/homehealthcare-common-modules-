//package com.homehealthcare.homehealthcare_common_modules.mappers;
//
//import com.homehealthcare.homehealthcare_common_modules.dto.PayrollPeriodDTO;
//import com.homehealthcare.homehealthcare_common_modules.entity.PayrollPeriod;
//import org.mapstruct.*;
//
//@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
//public interface PayrollPeriodMapper {
//
//    PayrollPeriodDTO payrollPeriodToPayrollPeriodDTO(PayrollPeriod payrollPeriod);
//
//    PayrollPeriod payrollPeriodDTOToPayrollPeriod(PayrollPeriodDTO payrollPeriodDTO);
//
//    @Mapping(target = "id", ignore = true)
//    @Mapping(target = "createdAt", ignore = true)
//    void updatePayrollPeriodFromDTO(PayrollPeriodDTO payrollPeriodDTO, @MappingTarget PayrollPeriod payrollPeriod);
//}