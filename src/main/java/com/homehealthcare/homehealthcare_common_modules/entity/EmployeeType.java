package com.homehealthcare.homehealthcare_common_modules.entity;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;

import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Table(name = "employee_types")
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class EmployeeType implements GrantedAuthority {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String type;

    @OneToMany(mappedBy = "employeeType")
    @ToString.Exclude
    private Set<Employee> employees;

    // Removed the redundant 'permissions' field
    // @ManyToMany(fetch = FetchType.EAGER)
    // @JoinTable(
    //         name = "employee_type_permissions",
    //         joinColumns = @JoinColumn(name = "employee_type_id"),
    //         inverseJoinColumns = @JoinColumn(name = "permission_id")
    // )
    // @JsonIgnore
    // @ToString.Exclude
    // private Set<Permission> permissions;

    @OneToMany(mappedBy = "employeeType", fetch = FetchType.EAGER)
    @ToString.Exclude
    // Removed @JsonIgnore to allow access during mapping
    private Set<EmployeeTypePermission> employeeTypePermissions;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @PrePersist
    protected void onCreate() {
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
    }

    @PreUpdate
    protected void onUpdate() {
        this.updatedAt = LocalDateTime.now();
    }

    @Override
    public String getAuthority() {
        return "ROLE_" + this.type.toUpperCase();
    }
}
