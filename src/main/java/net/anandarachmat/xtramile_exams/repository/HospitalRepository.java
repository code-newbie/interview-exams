package net.anandarachmat.xtramile_exams.repository;

import net.anandarachmat.xtramile_exams.entity.Hospital;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RepositoryRestResource(collectionResourceRel = "hospitals", path = "hospitals")
public interface HospitalRepository extends JpaRepository<Hospital, UUID> {

    // Find by exact hospital name (useful if name is unique)
    Optional<Hospital> findByHospitalName(String hospitalName);

    // Find hospitals by branch name
    List<Hospital> findByBranchName(String branchName);

    // Check existence by hospital name
    boolean existsByHospitalName(String hospitalName);

    // Search hospitals by name (contains, case-insensitive)
    List<Hospital> findByHospitalNameContainingIgnoreCase(String hospitalName);

    // Find hospitals with capacity greater than or equal to given value
    List<Hospital> findByCapacityGreaterThanEqual(Integer capacity);

    // Paginated listing (explicit for clarity)
    Page<Hospital> findAll(Pageable pageable);

    // Delete by primary key
    void deleteByHospitalId(UUID hospitalId);

    // Convenience finder by id (optional; JpaRepository provides findById)
    Optional<Hospital> findByHospitalId(UUID hospitalId);
}