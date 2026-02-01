package net.anandarachmat.xtramile_exams.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.UuidGenerator;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "master_patient")
public class MasterPatient {

    @Id
    @GeneratedValue
    @UuidGenerator
    @Column(name = "patient_id", columnDefinition = "uuid", updatable = false, nullable = false)
    private UUID patientId;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "gender")
    private String gender;

    @Column(name = "date_of_birth")
    private LocalDate dateOfBirth;

    @Column(name = "patient_national_id")
    private String patientNationalId;

    @Column(name = "phone")
    private String phone;

    @Column(name = "email")
    private String email;

    @Column(name = "is_merged")
    private Boolean isMerged;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @OneToMany(mappedBy = "patient", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<MedicalRecord> medicalRecords = new HashSet<>();

    @OneToMany(mappedBy = "patient", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<PatientAddress> patientAddresses = new HashSet<>();

    public MasterPatient() {}

    // getters and setters

    public UUID getPatientId() { return patientId; }
    public void setPatientId(UUID patientId) { this.patientId = patientId; }

    public String getFirstName() { return firstName; }
    public void setFirstName(String firstName) { this.firstName = firstName; }

    public String getLastName() { return lastName; }
    public void setLastName(String lastName) { this.lastName = lastName; }

    public String getGender() { return gender; }
    public void setGender(String gender) { this.gender = gender; }

    public LocalDate getDateOfBirth() { return dateOfBirth; }
    public void setDateOfBirth(LocalDate dateOfBirth) { this.dateOfBirth = dateOfBirth; }

    public String getPatientNationalId() { return patientNationalId; }
    public void setPatientNationalId(String patientNationalId) { this.patientNationalId = patientNationalId; }

    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public Boolean getIsMerged() { return isMerged; }
    public void setIsMerged(Boolean isMerged) { this.isMerged = isMerged; }

    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }

    public Set<MedicalRecord> getMedicalRecords() { return medicalRecords; }
    public void setMedicalRecords(Set<MedicalRecord> medicalRecords) { this.medicalRecords = medicalRecords; }

    public Set<PatientAddress> getPatientAddresses() { return patientAddresses; }
    public void setPatientAddresses(Set<PatientAddress> patientAddresses) { this.patientAddresses = patientAddresses; }
}