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

    // READ - Convenience finder for the composite id
//    Optional<PatientAddress> findByPatientIdIdPatientId(PatientAddressId patientAddressId);

    // READ - Find all address links for a patient
    List<PatientAddress> findByIdPatientId(UUID patientId);

    // READ - Find all patient links for an address
    List<PatientAddress> findByIdAddressId(UUID addressId);

    // READ - Check if a specific patient-address relation exists
    boolean existsByIdPatientIdAndIdAddressId(UUID patientId, UUID addressId);

    // READ - Paginated listing
    Page<PatientAddress> findAll(Pageable pageable);

    // DELETE - Delete a relation by its composite key parts
    void deleteByIdPatientIdAndIdAddressId(UUID patientId, UUID addressId);
}