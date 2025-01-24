package com.homehealthcare.homehealthcare_common_modules.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Entity representing an employee in the system.
 * Implements UserDetails for Spring Security integration and authentication.
 * Manages employee information, roles, and permissions.
 *
 * @see UserDetails
 * @see EmployeeType
 * @see EmployeeIndividualPermission
 */
@Entity
@Table(
        name = "employees",
        indexes = {
                @Index(name = "idx_employee_username", columnList = "username"),
                @Index(name = "idx_employee_email", columnList = "email")
        }
)
@Getter
@Setter
@NoArgsConstructor  // Public no-args constructor required for MapStruct and JPA
@EqualsAndHashCode(of = "id")
@ToString(exclude = {
        "clientEmployeeLinks",
        "employeePayrolls",
        "assignedSchedules",
        "replacementSchedules",
        "individualPermissions"
})
public class Employee implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NonNull
    @Column(name = "first_name", nullable = false)
    private String firstName;

    @NonNull
    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Nullable
    @Column(name = "birthday")
    private String birthday;

    @NonNull
    @Column(name = "rate_per_hour", nullable = false)
    private Double ratePerHour;

    @NonNull
    @Column(name = "username", nullable = false, unique = true, length = 50)
    private String username;

    @NonNull
    @Column(name = "password", nullable = false)
    private String password;

    @NonNull
    @Column(name = "email", nullable = false, unique = true, length = 100)
    private String email;

    @Nullable
    @Column(name = "zipcode", length = 10)
    private String zipcode;

    @Nullable
    @Column(name = "address")
    private String address;

    // Removed precision and scale from latitude and longitude
    // Floating-point fields should not specify scale; scale only applies to DECIMAL/NUMERIC
    @Nullable
    @Column(name = "latitude")
    private Double latitude;

    @Nullable
    @Column(name = "longitude")
    private Double longitude;

    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;
    
    @Column(name = "updated_at", nullable = false)
    private LocalDateTime updatedAt;

    // Relationships

    @OneToMany(mappedBy = "employee", fetch = FetchType.LAZY)
    @JsonIgnore
    private List<ClientEmployeeLink> clientEmployeeLinks = new ArrayList<>();

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "employee_type_id")
    private EmployeeType employeeType;

    @OneToMany(mappedBy = "employee", fetch = FetchType.LAZY)
    @JsonIgnore
    private List<EmployeePayroll> employeePayrolls = new ArrayList<>();

    @OneToMany(mappedBy = "employee", fetch = FetchType.LAZY)
    @JsonIgnore
    private List<Schedule> assignedSchedules = new ArrayList<>();

    @OneToMany(mappedBy = "replacementEmployee", fetch = FetchType.LAZY)
    @JsonIgnore
    private List<Schedule> replacementSchedules = new ArrayList<>();

    @OneToMany(
            mappedBy = "employee",
            cascade = CascadeType.ALL,
            orphanRemoval = true,
            fetch = FetchType.EAGER
    )
    private Set<EmployeeIndividualPermission> individualPermissions = new HashSet<>();

    /**
     * Creates a new employee with required fields.
     * The fields are validated to ensure none of the required ones are null.
     *
     * @param firstName   the employee's first name
     * @param lastName    the employee's last name
     * @param username    unique username for authentication
     * @param password    encrypted password
     * @param email       unique email address
     * @param ratePerHour hourly rate for the employee
     * @throws IllegalArgumentException if any required field is null
     */
    public Employee(
            @NonNull String firstName,
            @NonNull String lastName,
            @NonNull String username,
            @NonNull String password,
            @NonNull String email,
            @NonNull Double ratePerHour
    ) {
        this.firstName = Objects.requireNonNull(firstName, "firstName must not be null");
        this.lastName = Objects.requireNonNull(lastName, "lastName must not be null");
        this.username = Objects.requireNonNull(username, "username must not be null");
        this.password = Objects.requireNonNull(password, "password must not be null");
        this.email = Objects.requireNonNull(email, "email must not be null");
        this.ratePerHour = Objects.requireNonNull(ratePerHour, "ratePerHour must not be null");
    }

    /**
     * Replaces the set of individual permissions for this employee.
     * Ensures proper bidirectional relationship handling.
     *
     * @param permissions the new set of permissions
     */
    public void setIndividualPermissions(@Nullable Set<EmployeeIndividualPermission> permissions) {
        this.individualPermissions.clear();
        if (permissions != null) {
            permissions.forEach(this::addIndividualPermission);
        }
    }

    /**
     * Adds a single individual permission to this employee.
     * Ensures the 'employee' field in EmployeeIndividualPermission is set correctly.
     *
     * @param permission the permission to add
     * @throws IllegalArgumentException if permission is null
     */
    public void addIndividualPermission(@NonNull EmployeeIndividualPermission permission) {
        Objects.requireNonNull(permission, "permission must not be null");
        individualPermissions.add(permission);
        permission.setEmployee(this);
    }

    /**
     * Removes a single individual permission from this employee.
     *
     * @param permission the permission to remove
     */
    public void removeIndividualPermission(@NonNull EmployeeIndividualPermission permission) {
        Objects.requireNonNull(permission, "permission must not be null");
        individualPermissions.remove(permission);
        permission.setEmployee(null);
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

    // UserDetails implementation

    @Override
    @JsonIgnore
    @NonNull
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Set<GrantedAuthority> authorities = new HashSet<>();

        // Add role-based permissions
        if (employeeType != null && employeeType.getEmployeeTypePermissions() != null) {
            authorities.addAll(employeeType.getEmployeeTypePermissions().stream()
                    .flatMap(etypePerm -> {
                        Stream.Builder<GrantedAuthority> streamBuilder = Stream.builder();
                        var basePermission = etypePerm.getPermission().getPermissionType();

                        if (etypePerm.getCanRead()) {
                            streamBuilder.add(new SimpleGrantedAuthority(basePermission.withAction("READ")));
                        }
                        if (etypePerm.getCanWrite()) {
                            streamBuilder.add(new SimpleGrantedAuthority(basePermission.withAction("WRITE")));
                        }
                        if (etypePerm.getCanDelete()) {
                            streamBuilder.add(new SimpleGrantedAuthority(basePermission.withAction("DELETE")));
                        }
                        return streamBuilder.build();
                    })
                    .collect(Collectors.toSet()));
        }

        // Add individual permissions
        authorities.addAll(individualPermissions.stream()
                .flatMap(permission -> {
                    Stream.Builder<SimpleGrantedAuthority> streamBuilder = Stream.builder();
                    var basePermission = permission.getPermission().getPermissionType();

                    if (permission.getCanRead()) {
                        streamBuilder.add(new SimpleGrantedAuthority(basePermission.withAction("READ")));
                    }
                    if (permission.getCanWrite()) {
                        streamBuilder.add(new SimpleGrantedAuthority(basePermission.withAction("WRITE")));
                    }
                    if (permission.getCanDelete()) {
                        streamBuilder.add(new SimpleGrantedAuthority(basePermission.withAction("DELETE")));
                    }
                    return streamBuilder.build();
                })
                .collect(Collectors.toSet()));

        return Collections.unmodifiableSet(authorities);
    }

    @Override
    @JsonIgnore
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    @JsonIgnore
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    @JsonIgnore
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    @JsonIgnore
    public boolean isEnabled() {
        return true;
    }
}