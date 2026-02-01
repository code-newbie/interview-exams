package net.anandarachmat.xtramile_exams.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.io.Serializable;
import java.util.Objects;
import java.util.UUID;

@Embeddable
public class PatientAddressId implements Serializable {

    @Column(name = "patient_id", columnDefinition = "uuid")
    private UUID patientId;

    @Column(name = "address_id", columnDefinition = "uuid")
    private UUID addressId;

    public PatientAddressId() {}

    public PatientAddressId(UUID patientId, UUID addressId) {
        this.patientId = patientId;
        this.addressId = addressId;
    }

    // getters, setters, equals, hashCode

    public UUID getPatientId() { return patientId; }
    public void setPatientId(UUID patientId) { this.patientId = patientId; }

    public UUID getAddressId() { return addressId; }
    public void setAddressId(UUID addressId) { this.addressId = addressId; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PatientAddressId)) return false;
        PatientAddressId that = (PatientAddressId) o;
        return Objects.equals(patientId, that.patientId) && Objects.equals(addressId, that.addressId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(patientId, addressId);
    }
}
