package net.anandarachmat.xtramile_exams.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.UuidGenerator;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "medical_record")
public class MedicalRecord {

    @Id
    @GeneratedValue
    @UuidGenerator
    @Column(name = "medical_record_id", updatable = false, nullable = false)
    private UUID medicalRecordId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "patient_id", nullable = false)
    private MasterPatient patient;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "hospital_id", nullable = false)
    private Hospital hospital;

    @Column(name = "medical_record_no")
    private String medicalRecordNo;

    @Column(name = "visit_type")
    private String visitType;

    @Column(name = "insurance_provider")
    private String insuranceProvider;

    @Column(name = "admission_date")
    private LocalDate admissionDate;

    @Column(name = "discharge_date")
    private LocalDate dischargeDate;

    public MedicalRecord() {}

    // getters and setters

    public UUID getMedicalRecordId() { return medicalRecordId; }
    public void setMedicalRecordId(UUID medicalRecordId) { this.medicalRecordId = medicalRecordId; }

    public MasterPatient getPatient() { return patient; }
    public void setPatient(MasterPatient patient) { this.patient = patient; }

    public Hospital getHospital() { return hospital; }
    public void setHospital(Hospital hospital) { this.hospital = hospital; }

    public String getMedicalRecordNo() { return medicalRecordNo; }
    public void setMedicalRecordNo(String medicalRecordNo) { this.medicalRecordNo = medicalRecordNo; }

    public String getVisitType() { return visitType; }
    public void setVisitType(String visitType) { this.visitType = visitType; }

    public String getInsuranceProvider() { return insuranceProvider; }
    public void setInsuranceProvider(String insuranceProvider) { this.insuranceProvider = insuranceProvider; }

    public LocalDate getAdmissionDate() { return admissionDate; }
    public void setAdmissionDate(LocalDate admissionDate) { this.admissionDate = admissionDate; }

    public LocalDate getDischargeDate() { return dischargeDate; }
    public void setDischargeDate(LocalDate dischargeDate) { this.dischargeDate = dischargeDate; }
}