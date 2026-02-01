package net.anandarachmat.xtramile_exams.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "patient_address")
public class PatientAddress {

    @EmbeddedId
    private PatientAddressId id;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("patientId")
    @JoinColumn(name = "patient_id", nullable = false)
    private MasterPatient patient;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("addressId")
    @JoinColumn(name = "address_id", nullable = false)
    private Address address;

    public PatientAddress() {}

    public PatientAddress(MasterPatient patient, Address address) {
        this.patient = patient;
        this.address = address;
        this.id = new PatientAddressId(patient.getPatientId(), address.getAddressId());
    }

    // getters and setters

    public PatientAddressId getId() { return id; }
    public void setId(PatientAddressId id) { this.id = id; }

    public MasterPatient getPatient() { return patient; }
    public void setPatient(MasterPatient patient) { this.patient = patient; }

    public Address getAddress() { return address; }
    public void setAddress(Address address) { this.address = address; }
}

