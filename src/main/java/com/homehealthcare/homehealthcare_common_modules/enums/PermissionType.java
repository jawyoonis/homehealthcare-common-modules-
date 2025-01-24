package com.homehealthcare.homehealthcare_common_modules.enums;

import lombok.Getter;
import lombok.NonNull;
import org.springframework.lang.Nullable;

import java.util.Arrays;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Represents the core permission domains in the system.
 * Each permission can be combined with read/write/delete access flags in EmployeeTypePermission
 * to create granular access control.
 *
 * <p>Usage example:
 * A permission of EMPLOYEE combined with read=true, write=false, delete=false
 * would grant read-only access to employee management functionality.
 *
 * @since 1.0
 */
@Getter
public enum PermissionType {
    // Resource Management
    EMPLOYEE("Employee Management", "Controls access to employee data and operations"),
    CLIENT("Client Management", "Controls access to client data and operations"),
    SCHEDULE("Schedule Management", "Controls access to scheduling functionality"),

    // Type & Permission Management
    EMPLOYEE_TYPE("Employee Type Management", "Controls access to employee role types"),
    EMPLOYEE_TYPE_PERMISSION("Employee Type Permission", "Controls access to role-permission mappings"),
    PERMISSION("Permission Management", "Controls access to system permissions"),

    // Payroll Management
    EMPLOYEE_PAYROLL("Employee Payroll", "Controls access to employee payroll data"),
    CLIENT_PAYROLL("Client Payroll", "Controls access to client billing data"),
    PAYROLL_PERIOD("Payroll Period", "Controls access to payroll period management"),

    // Additional Management
    REPLACEMENT("Replacement Management", "Controls access to employee replacement functionality"),
    SCHEDULED_JOB("Scheduled Job", "Controls access to system scheduled tasks"),
    EMPLOYEE_ROLE("Employee Role", "Controls access to employee role assignments"),
    EMPLOYEE_PERMISSION("Employee Permission", "Controls access to employee permission assignments"),
    EVV_PERMISSION("EVV Permission", "Controls access to EVV permission assignments"),

    // Claims Management
    CLAIMS_PERMISSION("Claims Permission", "Controls access to claims generation and management");

    private static final Map<String, PermissionType> NAME_MAP = Arrays.stream(values())
            .collect(Collectors.toMap(PermissionType::name, Function.identity()));

    private final String displayName;
    private final String description;

    /**
     * Constructs a new PermissionType.
     *
     * @param displayName human-readable name of the permission
     * @param description detailed description of what the permission controls
     */
    PermissionType(@NonNull String displayName, @NonNull String description) {
        this.displayName = displayName;
        this.description = description;
    }

    /**
     * Finds a PermissionType by its exact name.
     *
     * @param name the exact name of the permission type
     * @return Optional containing the PermissionType if found, empty Optional otherwise
     */
    public static Optional<PermissionType> fromName(@Nullable String name) {
        return Optional.ofNullable(name).map(NAME_MAP::get);
    }

    /**
     * Checks if a permission type exists.
     *
     * @param name the name to check
     * @return true if the permission type exists, false otherwise
     */
    public static boolean exists(@Nullable String name) {
        return name != null && NAME_MAP.containsKey(name);
    }

    /**
     * Combines this permission with an action type to create a permission string.
     * Used primarily for Spring Security authorization checks.
     *
     * @param action the action type (e.g., "READ", "WRITE", "DELETE")
     * @return the combined permission string
     */
    public String withAction(@NonNull String action) {
        return name() + "_" + action.toUpperCase();
    }

    /**
     * Returns the permission type name in format used by Spring Security.
     *
     * @return the permission type name
     */
    @Override
    public String toString() {
        return name();
    }
}