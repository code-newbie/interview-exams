package net.anandarachmat.xtramile_exams.repository;

import net.anandarachmat.xtramile_exams.entity.MedicalRecord;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RepositoryRestResource(collectionResourceRel = "medicalRecords", path = "medical-records")
public interface MedicalRecordRepository extends JpaRepository<MedicalRecord, UUID> {

//    // Find by primary key (convenience; JpaRepository provides findById)
//    Optional<MedicalRecord> findByMedicalRecordId(UUID medicalRecordId);
//
//    // Find all records for a patient
//    List<MedicalRecord> findByPatientId(UUID patientId);
//
//    // Find all records for a hospital
//    List<MedicalRecord> findByHospitalId(UUID hospitalId);
//
//    // Find by record number (unique business identifier)
//    Optional<MedicalRecord> findByRecordNumber(String recordNumber);
//
//    // Search diagnosis/notes (contains, case-insensitive)
//    List<MedicalRecord> findByDiagnosisContainingIgnoreCase(String diagnosisFragment);
//
//    // Paginated listing (explicit for clarity)
//    Page<MedicalRecord> findAll(Pageable pageable);
//
//    // Existence check by record number
//    boolean existsByRecordNumber(String recordNumber);
//
//    // Delete by primary key
//    void deleteByMedicalRecordId(UUID medicalRecordId);
}