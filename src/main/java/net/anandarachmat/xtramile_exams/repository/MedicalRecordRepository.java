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

    // READ - Find by primary key
    Optional<MedicalRecord> findByMedicalRecordId(UUID medicalRecordId);

    // READ - Find all records for a patient
    List<MedicalRecord> findByPatientPatientId(UUID patientId);

    // READ - Find all records for a hospital
    List<MedicalRecord> findByHospitalHospitalId(UUID hospitalId);

    // READ - Find by record number (unique business identifier)
    Optional<MedicalRecord> findByMedicalRecordNo(String medicalRecordNo);

    // READ - Search diagnosis/notes (contains, case-insensitive)
    List<MedicalRecord> findByDiagnosisContainingIgnoreCase(String diagnosisFragment);

    // READ - Paginated listing
    Page<MedicalRecord> findAll(Pageable pageable);

    // READ - Existence check by record number
    boolean existsByMedicalRecordNo(String medicalRecordNo);

    // DELETE - Delete by primary key
    void deleteByMedicalRecordId(UUID medicalRecordId);
}