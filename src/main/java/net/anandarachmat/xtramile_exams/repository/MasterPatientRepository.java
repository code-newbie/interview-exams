package net.anandarachmat.xtramile_exams.repository;

import net.anandarachmat.xtramile_exams.entity.MasterPatient;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RepositoryRestResource(collectionResourceRel = "patients", path = "patients")
public interface MasterPatientRepository extends JpaRepository<MasterPatient, UUID> {

    // Find a patient by national id
    Optional<MasterPatient> findByPatientNationalId(String patientNationalId);

    // Find a patient by email
    Optional<MasterPatient> findByEmail(String email);

    // Check existence by email
    boolean existsByEmail(String email);

    // Search patients by first name (contains, case-insensitive)
    List<MasterPatient> findByFirstNameContainingIgnoreCase(String firstName);

    // Search patients by last name (contains, case-insensitive)
    List<MasterPatient> findByLastNameContainingIgnoreCase(String lastName);

    // Paginated listing (inherited from JpaRepository but explicit for clarity)
    Page<MasterPatient> findAll(Pageable pageable);

    // Delete by patient id
    void deleteByPatientId(UUID patientId);
}