package net.anandarachmat.xtramile_exams.repository;

import net.anandarachmat.xtramile_exams.entity.HospitalAddress;
import net.anandarachmat.xtramile_exams.entity.HospitalAddressId;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;
import java.util.UUID;

@RepositoryRestResource(collectionResourceRel = "hospitalAddresses", path = "hospital-addresses")
public interface HospitalAddressRepository extends JpaRepository<HospitalAddress, HospitalAddressId> {

//    // Find all address links for a hospital
//    List<HospitalAddress> findByHospitalId(UUID hospitalId);
//
//    // Find all hospital links for an address
//    List<HospitalAddress> findByAddressId(UUID addressId);
//
//    // Check if a specific hospital-address relation exists
//    boolean existsByHospitalIdAndAddressId(UUID hospitalId, UUID addressId);
//
//    // Delete a relation by its composite key parts
//    void deleteByHospitalIdAndAddressId(UUID hospitalId, UUID addressId);
//
//    // Paginated listing (explicit)
//    Page<HospitalAddress> findAll(Pageable pageable);
}