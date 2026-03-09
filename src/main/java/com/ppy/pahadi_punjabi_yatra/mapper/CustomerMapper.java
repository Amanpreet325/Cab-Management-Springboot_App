package com.ppy.pahadi_punjabi_yatra.mapper;

import com.ppy.pahadi_punjabi_yatra.dto.CustomerDTO;
import com.ppy.pahadi_punjabi_yatra.model.Customer;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class CustomerMapper {

    public CustomerDTO toDTO(Customer customer) {
        if (customer == null) {
            return null;
        }
        CustomerDTO dto = new CustomerDTO();
        dto.setId(customer.getId());
        dto.setName(customer.getName());
        dto.setEmail(customer.getEmail());
        dto.setPhoneNumber(customer.getPhone_number());
        dto.setRegistrationDt(customer.getRegistrationDt());
        return dto;
    }

    public Customer toEntity(CustomerDTO dto) {
        if (dto == null) {
            return null;
        }
        Customer customer = new Customer();
        customer.setId(dto.getId());
        customer.setName(dto.getName());
        customer.setEmail(dto.getEmail());
        customer.setPhone_number(dto.getPhoneNumber());
        customer.setRegistrationDt(dto.getRegistrationDt() != null ? dto.getRegistrationDt() : LocalDateTime.now());
        return customer;
    }

    public List<CustomerDTO> toDTOList(List<Customer> customers) {
        if (customers == null) {
            return null;
        }
        return customers.stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    public void updateEntityFromDTO(CustomerDTO dto, Customer customer) {
        if (dto.getName() != null) {
            customer.setName(dto.getName());
        }
        if (dto.getEmail() != null) {
            customer.setEmail(dto.getEmail());
        }
        if (dto.getPhoneNumber() != null) {
            customer.setPhone_number(dto.getPhoneNumber());
        }
    }
}
