package com.ppy.pahadi_punjabi_yatra.repository.cab;

import com.ppy.pahadi_punjabi_yatra.model.Cab;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CabRepository extends JpaRepository<Cab,Long> {
    List<Cab> findByStatus(String status);

    Optional<Cab> findById(Long id);
    Boolean existsByRegistrationNo(String registrationNo);
}
