package net.anandarachmat.xtramile_exams.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.UuidGenerator;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "hospital")
public class Hospital {

    @Id
    @GeneratedValue
    @UuidGenerator
    @Column(name = "hospital_id", columnDefinition = "uuid", updatable = false, nullable = false)
    private UUID hospitalId;

    @Column(name = "hospital_name")
    private String hospitalName;

    @Column(name = "branch_name")
    private String branchName;

    @Column(name = "capacity")
    private Integer capacity;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @OneToMany(mappedBy = "hospital", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<MedicalRecord> medicalRecords = new HashSet<>();

    public Hospital() {}

    // getters and setters

    public UUID getHospitalId() { return hospitalId; }
    public void setHospitalId(UUID hospitalId) { this.hospitalId = hospitalId; }

    public String getHospitalName() { return hospitalName; }
    public void setHospitalName(String hospitalName) { this.hospitalName = hospitalName; }

    public String getBranchName() { return branchName; }
    public void setBranchName(String branchName) { this.branchName = branchName; }

    public Integer getCapacity() { return capacity; }
    public void setCapacity(Integer capacity) { this.capacity = capacity; }

    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }

    public Set<MedicalRecord> getMedicalRecords() { return medicalRecords; }
    public void setMedicalRecords(Set<MedicalRecord> medicalRecords) { this.medicalRecords = medicalRecords; }
}