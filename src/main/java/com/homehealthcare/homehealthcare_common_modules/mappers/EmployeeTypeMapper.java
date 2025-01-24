//package com.homehealthcare.homehealthcare_common_modules.mappers;
//
//import com.homehealthcare.homehealthcare_common_modules.dto.EmployeeTypeDTO;
//import com.homehealthcare.homehealthcare_common_modules.entity.EmployeeType;
//import org.mapstruct.*;
//
//import java.util.List;
//
//@Mapper(
//        componentModel = "spring",
//        uses = {EmployeeTypePermissionMapper.class}, // Specify the nested mapper
//        unmappedTargetPolicy = ReportingPolicy.IGNORE
//)
//public interface EmployeeTypeMapper {
//
//    // Removed the INSTANCE field
//    // EmployeeTypeMapper INSTANCE = Mappers.getMapper(EmployeeTypeMapper.class);
//
//    @Mapping(target = "employeeIds", ignore = true)
//    @Mapping(target = "permissionIds", ignore = true)
//    @Mapping(target = "permissions", source = "employeeTypePermissions")
//    EmployeeTypeDTO employeeTypeToEmployeeTypeDTO(EmployeeType employeeType);
//
//    @Mapping(target = "employees", ignore = true)
//    @Mapping(target = "employeeTypePermissions", ignore = true)
//    EmployeeType employeeTypeDTOToEmployeeType(EmployeeTypeDTO employeeTypeDTO);
//
//    List<EmployeeTypeDTO> employeeTypesToEmployeeTypeDTOs(List<EmployeeType> employeeTypes);
//
//    List<EmployeeType> employeeTypeDTOsToEmployeeTypes(List<EmployeeTypeDTO> employeeTypeDTOs);
//
//    @Mapping(target = "id", ignore = true)
//    @Mapping(target = "employees", ignore = true)
//    @Mapping(target = "employeeTypePermissions", ignore = true)
//    @Mapping(target = "createdAt", ignore = true)
//    void updateEmployeeTypeFromDTO(EmployeeTypeDTO employeeTypeDTO, @MappingTarget EmployeeType employeeType);
//}