package net.anandarachmat.xtramile_exams.repository;

import net.anandarachmat.xtramile_exams.entity.Address;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RepositoryRestResource(collectionResourceRel = "addresses", path = "addresses")
public interface AddressRepository extends JpaRepository<Address, UUID> {

    Optional<Address> findByAddressId(UUID addressId);

    List<Address> findBySuburb(String suburb);

    List<Address> findBySuburbContainingIgnoreCase(String suburbFragment);

    List<Address> findByStreetContainingIgnoreCase(String streetFragment);

    List<Address> findByCountryContainingIgnoreCase(String countryFragment);

    List<Address> findByPostCode(String postCode);

    boolean existsByPostCode(String postCode);

    Page<Address> findAll(Pageable pageable);

    void deleteByAddressId(UUID addressId);
}