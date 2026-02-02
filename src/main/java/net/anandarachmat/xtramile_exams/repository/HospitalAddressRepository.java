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

    // READ - Find all address links for a hospital
    List<HospitalAddress> findByIdHospitalId(UUID hospitalId);

    // READ - Find all hospital links for an address
    List<HospitalAddress> findByIdAddressId(UUID addressId);

    // READ - Check if a specific hospital-address relation exists
    boolean existsByIdHospitalIdAndIdAddressId(UUID hospitalId, UUID addressId);

    // READ - Paginated listing
    Page<HospitalAddress> findAll(Pageable pageable);

    // DELETE - Delete a relation by its composite key parts
    void deleteByIdHospitalIdAndIdAddressId(UUID hospitalId, UUID addressId);
}