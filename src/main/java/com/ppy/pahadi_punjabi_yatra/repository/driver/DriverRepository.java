package com.ppy.pahadi_punjabi_yatra.repository.driver;

import com.ppy.pahadi_punjabi_yatra.model.Driver;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DriverRepository extends JpaRepository<Driver,Long> {

    Optional<Driver> findById(Long id);
    boolean existsByLicenseNumber(String LicenseNumber);

    Optional<Driver> findByCab_Id(Long cabId);
}
