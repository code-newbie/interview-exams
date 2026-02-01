package net.anandarachmat.xtramile_exams.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.io.Serializable;
import java.util.Objects;
import java.util.UUID;

@Embeddable
public class HospitalAddressId implements Serializable {

    @Column(name = "hospital_id", columnDefinition = "uuid")
    private UUID hospitalId;

    @Column(name = "address_id", columnDefinition = "uuid")
    private UUID addressId;

    public HospitalAddressId() {}

    public HospitalAddressId(UUID hospitalId, UUID addressId) {
        this.hospitalId = hospitalId;
        this.addressId = addressId;
    }

    // getters, setters, equals, hashCode

    public UUID getHospitalId() { return hospitalId; }
    public void setHospitalId(UUID hospitalId) { this.hospitalId = hospitalId; }

    public UUID getAddressId() { return addressId; }
    public void setAddressId(UUID addressId) { this.addressId = addressId; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof HospitalAddressId)) return false;
        HospitalAddressId that = (HospitalAddressId) o;
        return Objects.equals(hospitalId, that.hospitalId) && Objects.equals(addressId, that.addressId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(hospitalId, addressId);
    }
}
