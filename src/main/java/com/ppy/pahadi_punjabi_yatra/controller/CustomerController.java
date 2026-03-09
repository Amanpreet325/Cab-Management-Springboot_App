package com.ppy.pahadi_punjabi_yatra.controller;

import com.ppy.pahadi_punjabi_yatra.dto.CustomerDTO;
import com.ppy.pahadi_punjabi_yatra.mapper.CustomerMapper;
import com.ppy.pahadi_punjabi_yatra.model.Cab;
import com.ppy.pahadi_punjabi_yatra.model.Customer;
import com.ppy.pahadi_punjabi_yatra.service.customer.CustomerService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {

    private final CustomerService customerService;
    private final CustomerMapper customerMapper;

    public CustomerController(CustomerService customerService, CustomerMapper customerMapper) {
        this.customerService = customerService;
        this.customerMapper = customerMapper;
    }

    @PostMapping
    public ResponseEntity<?> registerCustomer(@Valid @RequestBody CustomerDTO customerDTO) {
        // Check if email is unique
        if (!customerService.isEmailUnique(customerDTO.getEmail())) {
            return ResponseEntity.badRequest().body("Email already exists");
        }

        Customer customer = customerMapper.toEntity(customerDTO);
        Customer savedCustomer = customerService.registerCustomer(customer);
        return ResponseEntity.status(HttpStatus.CREATED).body(customerMapper.toDTO(savedCustomer));
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getCustomerById(@PathVariable Long id) {
        Customer customer = customerService.getCustomerById(id);
        if (customer == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(customerMapper.toDTO(customer));
    }

    @GetMapping("/check-email")
    public ResponseEntity<Boolean> checkEmailUnique(@RequestParam String email) {
        return ResponseEntity.ok(customerService.isEmailUnique(email));
    }
}

