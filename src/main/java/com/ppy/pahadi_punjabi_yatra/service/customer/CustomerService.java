package com.ppy.pahadi_punjabi_yatra.service.customer;

import com.ppy.pahadi_punjabi_yatra.model.Customer;

public interface CustomerService {

    Customer registerCustomer(Customer customer);

    boolean isEmailUnique(String email);

    Customer getCustomerById(Long id);
}
