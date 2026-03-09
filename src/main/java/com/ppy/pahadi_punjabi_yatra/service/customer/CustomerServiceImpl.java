package com.ppy.pahadi_punjabi_yatra.service.customer;

import com.ppy.pahadi_punjabi_yatra.model.Cab;
import com.ppy.pahadi_punjabi_yatra.model.Customer;
import com.ppy.pahadi_punjabi_yatra.repository.customer.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    private CustomerRepository customerRepository;

//       public CustomerServiceImpl(CustomerRepository customerRepository){
//           this.customerRepository=customerRepository;
//       }
    @Override
    public boolean isEmailUnique(String email){
        if(customerRepository.existsByEmail(email)){
            return false;
        }
        return true;
    }

    @Override
    public Customer registerCustomer(Customer customer){
        if(!isEmailUnique(customer.getEmail())){
            throw new RuntimeException("Email already Exists ");
        }
        return customerRepository.save(customer);
    }
    @Override
    public Customer getCustomerById(Long id) {
        return customerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Customer not found"));
    }




}
