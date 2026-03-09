package com.ppy.pahadi_punjabi_yatra.repository.customer;

import com.ppy.pahadi_punjabi_yatra.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer,Long> {
    boolean existsByEmail(String email);
}
