package com.homehealthcare.homehealthcare_common_modules.utils;

import jakarta.persistence.Embeddable;
import lombok.*;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ClientEmployeeLinkId implements Serializable {

    private Long clientId;
    private Long employeeId;

    // hashCode and equals methods
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ClientEmployeeLinkId that = (ClientEmployeeLinkId) o;
        return Objects.equals(clientId, that.clientId) && Objects.equals(employeeId, that.employeeId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(clientId, employeeId);
    }
}
