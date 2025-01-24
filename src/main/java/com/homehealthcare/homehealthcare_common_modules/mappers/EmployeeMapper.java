//package com.homehealthcare.homehealthcare_common_modules.mappers;
//
//import com.homehealthcare.homehealthcare_common_modules.dto.EmployeeDTO;
//import com.homehealthcare.homehealthcare_common_modules.dto.EmployeeIndividualPermissionDTO;
//import com.homehealthcare.homehealthcare_common_modules.entity.Employee;
//import com.homehealthcare.homehealthcare_common_modules.entity.EmployeeIndividualPermission;
//import com.homehealthcare.homehealthcare_common_modules.entity.Permission;
//import org.mapstruct.*;
//
//import java.util.List;
//import java.util.Set;
//
///**
// * Mapper interface for Employee entity and EmployeeDTO.
// * Utilizes MapStruct for automatic implementation.
// */
//@Mapper(componentModel = "spring", uses = { PermissionMapper.class }, unmappedTargetPolicy = ReportingPolicy.IGNORE)
//public interface EmployeeMapper {
//
//    /**
//     * Maps an Employee entity to an EmployeeDTO.
//     * Extracts employeeTypeId from the associated EmployeeType entity.
//     *
//     * @param employee the Employee entity
//     * @return the mapped EmployeeDTO
//     */
//    @Mapping(target = "employeeTypeId", source = "employeeType.id")
//    @Mapping(target = "individualPermissions", source = "individualPermissions")
//    EmployeeDTO employeeToEmployeeDTO(Employee employee);
//
//    /**
//     * Maps an EmployeeDTO to an Employee entity.
//     * Ignores employeeType; it should be set in the service layer.
//     * Ignores password to prevent accidental mapping from DTO.
//     *
//     * @param employeeDTO the EmployeeDTO
//     * @return the mapped Employee entity
//     */
//    @Mapping(target = "employeeType", ignore = true)
//    @Mapping(target = "password", ignore = true) // Password should not be mapped from DTO for security
//    @Mapping(target = "individualPermissions", ignore = true)
//    Employee employeeDTOToEmployee(EmployeeDTO employeeDTO);
//
//    /**
//     * Maps a list of Employee entities to a list of EmployeeDTOs.
//     *
//     * @param employees the list of Employee entities
//     * @return the list of mapped EmployeeDTOs
//     */
//    List<EmployeeDTO> employeesToEmployeeDTOs(List<Employee> employees);
//
//    /**
//     * Maps a list of EmployeeDTOs to a list of Employee entities.
//     * Ignores employeeType and password; they should be handled separately.
//     *
//     * @param employeeDTOs the list of EmployeeDTOs
//     * @return the list of mapped Employee entities
//     */
//    List<Employee> employeeDTOsToEmployees(List<EmployeeDTO> employeeDTOs);
//
//    /**
//     * Updates an existing Employee entity with values from an EmployeeDTO.
//     * Ignores fields that should not be updated directly.
//     *
//     * @param employeeDTO the EmployeeDTO containing updated data
//     * @param employee    the Employee entity to be updated
//     */
//    @Mapping(target = "id", ignore = true)
//    @Mapping(target = "createdAt", ignore = true)
//    @Mapping(target = "updatedAt", ignore = true)
//    @Mapping(target = "clientEmployeeLinks", ignore = true)
//    @Mapping(target = "employeePayrolls", ignore = true)
//    @Mapping(target = "employeeType", ignore = true)
//    @Mapping(target = "password", ignore = true)
//    @Mapping(target = "individualPermissions", ignore = true)
//    void updateEmployeeFromDTO(EmployeeDTO employeeDTO, @MappingTarget Employee employee);
//
//    /**
//     * Maps an EmployeeIndividualPermission entity to EmployeeIndividualPermissionDTO.
//     *
//     * @param eip the EmployeeIndividualPermission entity
//     * @return the mapped EmployeeIndividualPermissionDTO
//     */
//    @Mapping(target = "permissionId", source = "permission.id")
//    @Mapping(target = "permissionType", source = "permission.permissionType")
//    EmployeeIndividualPermissionDTO employeeIndividualPermissionToDTO(EmployeeIndividualPermission eip);
//
//    /**
//     * Maps an EmployeeIndividualPermissionDTO to EmployeeIndividualPermission entity.
//     *
//     * @param dto the EmployeeIndividualPermissionDTO
//     * @return the mapped EmployeeIndividualPermission entity
//     */
//    @Mapping(target = "employee", ignore = true)
//    @Mapping(target = "permission", source = "permissionId", qualifiedByName = "mapPermissionById")
//    EmployeeIndividualPermission dtoToEmployeeIndividualPermission(EmployeeIndividualPermissionDTO dto);
//
//    /**
//     * Maps a Set of EmployeeIndividualPermission entities to a Set of EmployeeIndividualPermissionDTOs.
//     *
//     * @param eips the set of EmployeeIndividualPermission entities
//     * @return the set of mapped EmployeeIndividualPermissionDTOs
//     */
//    Set<EmployeeIndividualPermissionDTO> employeeIndividualPermissionsToDTOs(Set<EmployeeIndividualPermission> eips);
//
//    /**
//     * Maps a Set of EmployeeIndividualPermissionDTOs to a Set of EmployeeIndividualPermission entities.
//     *
//     * @param dtos the set of EmployeeIndividualPermissionDTOs
//     * @return the set of mapped EmployeeIndividualPermission entities
//     */
//    Set<EmployeeIndividualPermission> dtosToEmployeeIndividualPermissions(Set<EmployeeIndividualPermissionDTO> dtos);
//
//    /**
//     * After mapping from EmployeeDTO to Employee, set the individual permissions.
//     * This method ensures that the employee reference is correctly set in each EmployeeIndividualPermission.
//     *
//     * @param employeeDTO the source EmployeeDTO
//     * @param employee    the target Employee entity
//     */
//    @AfterMapping
//    default void setEmployeeInIndividualPermissions(EmployeeDTO employeeDTO, @MappingTarget Employee employee) {
//        if (employeeDTO.getIndividualPermissions() != null && !employeeDTO.getIndividualPermissions().isEmpty()) {
//            Set<EmployeeIndividualPermission> permissions = dtosToEmployeeIndividualPermissions(employeeDTO.getIndividualPermissions());
//            permissions.forEach(permission -> permission.setEmployee(employee));
//            employee.setIndividualPermissions(permissions);
//        } else {
//            employee.setIndividualPermissions(null);
//        }
//    }
//
//    /**
//     * Custom method to map permission IDs to Permission entities.
//     * This is used in dtoToEmployeeIndividualPermission mapping.
//     *
//     * @param id the ID of the permission
//     * @return a Permission entity with the given ID
//     */
//    @Named("mapPermissionById")
//    default Permission mapPermissionById(Long id) {
//        Permission permission = new Permission();
//        permission.setId(id);
//        return permission;
//    }
//}