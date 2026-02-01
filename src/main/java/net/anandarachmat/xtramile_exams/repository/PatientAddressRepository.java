package net.anandarachmat.xtramile_exams.repository;

import net.anandarachmat.xtramile_exams.entity.PatientAddress;
import net.anandarachmat.xtramile_exams.entity.PatientAddressId;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RepositoryRestResource(collectionResourceRel = "patientAddresses", path = "patient-addresses")
public interface PatientAddressRepository extends JpaRepository<PatientAddress, PatientAddressId> {

//    // Convenience finder for the composite id (JpaRepository provides findById as well)
//    Optional<PatientAddress> findByPatientAddressId(PatientAddressId patientAddressId);
//
//    // Find all address links for a patient
//    List<PatientAddress> findByPatientId(UUID patientId);
//
//    // Find all patient links for an address
//    List<PatientAddress> findByAddressId(UUID addressId);
//
//    // Check if a specific patient-address relation exists
//    boolean existsByPatientIdAndAddressId(UUID patientId, UUID addressId);
//
//    // Delete a relation by its composite key parts
//    void deleteByPatientIdAndAddressId(UUID patientId, UUID addressId);
//
//    // Paginated listing (explicit)
//    Page<PatientAddress> findAll(Pageable pageable);
}