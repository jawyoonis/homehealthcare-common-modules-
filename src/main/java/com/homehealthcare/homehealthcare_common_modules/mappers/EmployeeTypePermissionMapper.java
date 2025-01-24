//package com.homehealthcare.homehealthcare_common_modules.mappers;
//
//import com.homehealthcare.homehealthcare_common_modules.dto.EmployeeTypePermissionDTO;
//import com.homehealthcare.homehealthcare_common_modules.entity.EmployeeTypePermission;
//import org.mapstruct.*;
//import org.mapstruct.factory.Mappers;
//
//import java.util.List;
//
//@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
//public interface EmployeeTypePermissionMapper {
//    EmployeeTypePermissionMapper INSTANCE = Mappers.getMapper(EmployeeTypePermissionMapper.class);
//
//    @Mapping(target = "employeeTypeId", source = "employeeType.id")
//    @Mapping(target = "permissionId", source = "permission.id")
//    @Mapping(target = "permissionType", source = "permission.permissionType")
//    EmployeeTypePermissionDTO employeeTypePermissionToEmployeeTypePermissionDTO(EmployeeTypePermission employeeTypePermission);
//
//    @Mapping(target = "employeeType", ignore = true)
//    @Mapping(target = "permission", ignore = true)
//    EmployeeTypePermission employeeTypePermissionDTOToEmployeeTypePermission(EmployeeTypePermissionDTO employeeTypePermissionDTO);
//
//    List<EmployeeTypePermissionDTO> employeeTypePermissionsToEmployeeTypePermissionDTOs(List<EmployeeTypePermission> employeeTypePermissions);
//
//    List<EmployeeTypePermission> employeeTypePermissionDTOsToEmployeeTypePermissions(List<EmployeeTypePermissionDTO> employeeTypePermissionDTOs);
//
//    @Mapping(target = "id", ignore = true)
//    @Mapping(target = "employeeType", ignore = true)
//    @Mapping(target = "permission", ignore = true)
//    void updateEmployeeTypePermissionFromDTO(EmployeeTypePermissionDTO employeeTypePermissionDTO, @MappingTarget EmployeeTypePermission employeeTypePermission);
//}