package com.ppy.pahadi_punjabi_yatra.repository.booking;

import com.ppy.pahadi_punjabi_yatra.model.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookingRepository extends JpaRepository<Booking,Long> {

    boolean existsById(Long id);
}
