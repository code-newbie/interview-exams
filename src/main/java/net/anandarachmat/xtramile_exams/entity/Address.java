package net.anandarachmat.xtramile_exams.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.UuidGenerator;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "address")
public class Address {

    @Id
    @GeneratedValue
    @UuidGenerator
    @Column(name = "address_id", columnDefinition = "uuid", updatable = false, nullable = false)
    private UUID addressId;

    @Column(name = "address_type")
    private String addressType;

    @Column(name = "street")
    private String street;

    @Column(name = "suburb")
    private String suburb;

    @Column(name = "state")
    private String state;

    @Column(name = "post_code")
    private String postCode;

    @Column(name = "country")
    private String country;

    @OneToMany(mappedBy = "address", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<PatientAddress> patientAddresses = new HashSet<>();

    @OneToMany(mappedBy = "address", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<HospitalAddress> hospitalAddresses = new HashSet<>();

    public Address() {}

    // getters and setters

    public UUID getAddressId() { return addressId; }
    public void setAddressId(UUID addressId) { this.addressId = addressId; }

    public String getAddressType() { return addressType; }
    public void setAddressType(String addressType) { this.addressType = addressType; }

    public String getStreet() { return street; }
    public void setStreet(String street) { this.street = street; }

    public String getSuburb() { return suburb; }
    public void setSuburb(String suburb) { this.suburb = suburb; }

    public String getState() { return state; }
    public void setState(String state) { this.state = state; }

    public String getPostCode() { return postCode; }
    public void setPostCode(String postCode) { this.postCode = postCode; }

    public String getCountry() { return country; }
    public void setCountry(String country) { this.country = country; }

    public Set<PatientAddress> getPatientAddresses() { return patientAddresses; }
    public void setPatientAddresses(Set<PatientAddress> patientAddresses) { this.patientAddresses = patientAddresses; }

    public Set<HospitalAddress> getHospitalAddresses() { return hospitalAddresses; }
    public void setHospitalAddresses(Set<HospitalAddress> hospitalAddresses) { this.hospitalAddresses = hospitalAddresses; }
}