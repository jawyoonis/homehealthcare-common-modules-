package com.homehealthcare.homehealthcare_common_modules.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.homehealthcare.homehealthcare_common_modules.enums.PermissionType;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.lang.NonNull;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

/**
 * Entity representing a system permission.
 * Each permission represents a core functionality domain that can be controlled
 * through read/write/delete flags in {@link EmployeeTypePermission} and
 * {@link EmployeeIndividualPermission}.
 *
 * @see PermissionType
 * @see EmployeeTypePermission
 * @see EmployeeIndividualPermission
 */
@Entity
@Table(name = "permissions")
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
@ToString(exclude = {"employeeTypePermissions", "employeeIndividualPermissions"})
public class Permission implements GrantedAuthority {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NonNull
    @Enumerated(EnumType.STRING)
    @Column(name = "permission_type", nullable = false, unique = true)
    private PermissionType permissionType;

    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @OneToMany(mappedBy = "permission", fetch = FetchType.LAZY)
    @JsonIgnore
    private Set<EmployeeTypePermission> employeeTypePermissions = new HashSet<>();

    @OneToMany(
            mappedBy = "permission",
            cascade = CascadeType.ALL,
            orphanRemoval = true,
            fetch = FetchType.LAZY
    )
    @JsonIgnore
    private Set<EmployeeIndividualPermission> employeeIndividualPermissions = new HashSet<>();

    /**
     * Creates a new Permission with the specified type.
     *
     * @param permissionType the type of permission
     * @throws IllegalArgumentException if permissionType is null
     */
    public Permission(@NonNull PermissionType permissionType) {
        this.permissionType = permissionType;
    }

    @PrePersist
    protected void onCreate() {
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
    }

    @PreUpdate
    protected void onUpdate() {
        this.updatedAt = LocalDateTime.now();
    }

    /**
     * Returns the permission authority name used by Spring Security.
     * This represents the base permission without any action flags.
     *
     * @return the permission authority name
     */
    @Override
    @NonNull
    public String getAuthority() {
        return this.permissionType.name();
    }
}