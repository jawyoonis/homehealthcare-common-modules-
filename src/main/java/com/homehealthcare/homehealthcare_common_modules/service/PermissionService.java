package com.homehealthcare.homehealthcare_common_modules.service;
import com.homehealthcare.homehealthcare_common_modules.dto.PermissionDTO;

import java.util.List;

/**
 * Service interface for managing Permissions.
 * Note: The "permissionName" passed to findPermissionByName should match a valid
 * enum name in PermissionType. For example, "EMPLOYEE" or "CLIENT".
 */
public interface PermissionService {
    PermissionDTO findPermissionById(Long permissionId);

    /**
     * Finds a permission by its enum name (e.g., "EMPLOYEE", "CLIENT").
     * @param permissionName the name of the permission type enum
     * @return the PermissionDTO if found
     * @throws jakarta.persistence.EntityNotFoundException if no matching PermissionType or Permission is found
     */
    PermissionDTO findPermissionByName(String permissionName);

    PermissionDTO createPermission(PermissionDTO permissionDTO);
    PermissionDTO updatePermission(Long permissionId, PermissionDTO permissionDTO);
    void deletePermission(Long permissionId);
    List<PermissionDTO> getAllPermissions();
}
