package com.homehealthcare.homehealthcare_common_modules.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

@Entity
@Table(name = "employee_individual_permissions")
@Getter
@Setter
public class EmployeeIndividualPermission {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "employee_id")
    private Employee employee;

    @ManyToOne
    @JoinColumn(name = "permission_id")
    private Permission permission;

    @Column(name = "can_read")
    private Boolean canRead;

    @Column(name = "can_write")
    private Boolean canWrite;

    @Column(name = "can_delete")
    private Boolean canDelete;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof EmployeeIndividualPermission)) return false;
        EmployeeIndividualPermission that = (EmployeeIndividualPermission) o;
        return Objects.equals(getEmployee(), that.getEmployee()) &&
                Objects.equals(getPermission(), that.getPermission());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getEmployee(), getPermission());
    }
}