package net.anandarachmat.xtramile_exams.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "hospital_address")
public class HospitalAddress {

    @EmbeddedId
    private HospitalAddressId id;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("hospitalId")
    @JoinColumn(name = "hospital_id", nullable = false)
    private Hospital hospital;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("addressId")
    @JoinColumn(name = "address_id", nullable = false)
    private Address address;

    public HospitalAddress() {}

//    public HospitalAddress(Hospital hospital, Address address) {
//        this.hospital = hospital;
//        this.address = address;
//        this.id = new HospitalAddressId(hospital.getHospitalId(), address.getAddressId());
//    }

    // getters and setters

    public HospitalAddressId getId() { return id; }
    public void setId(HospitalAddressId id) { this.id = id; }

    public Hospital getHospital() { return hospital; }
    public void setHospital(Hospital hospital) { this.hospital = hospital; }

    public Address getAddress() { return address; }
    public void setAddress(Address address) { this.address = address; }
}

