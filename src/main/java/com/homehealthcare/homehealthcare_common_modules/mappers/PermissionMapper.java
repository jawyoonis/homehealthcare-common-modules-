//package com.homehealthcare.homehealthcare_common_modules.mappers;
//
//import com.homehealthcare.homehealthcare_common_modules.dto.PermissionDTO;
//import com.homehealthcare.homehealthcare_common_modules.entity.Permission;
//import org.mapstruct.*;
//
//import java.util.List;
//
//@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
//public interface PermissionMapper {
//
//    // Removed INSTANCE field since we're using componentModel = "spring"
//
//    PermissionDTO permissionToPermissionDTO(Permission permission);
//
//    @Mapping(target = "employeeTypePermissions", ignore = true)
//        // Removed mapping for 'employeeTypes' since it no longer exists in Permission
//    Permission permissionDTOToPermission(PermissionDTO permissionDTO);
//
//    List<PermissionDTO> permissionsToPermissionDTOs(List<Permission> permissions);
//
//    List<Permission> permissionDTOsToPermissions(List<PermissionDTO> permissionDTOs);
//
//    @Mapping(target = "id", ignore = true)
//    @Mapping(target = "employeeTypePermissions", ignore = true)
//        // Removed mapping for 'employeeTypes'
//    void updatePermissionFromDTO(PermissionDTO permissionDTO, @MappingTarget Permission permission);
//}
