package com.ppy.pahadi_punjabi_yatra.mapper;

import com.ppy.pahadi_punjabi_yatra.dto.BookingDTO;
import com.ppy.pahadi_punjabi_yatra.model.Booking;
import com.ppy.pahadi_punjabi_yatra.model.Cab;
import com.ppy.pahadi_punjabi_yatra.model.Customer;
import com.ppy.pahadi_punjabi_yatra.repository.cab.CabRepository;
import com.ppy.pahadi_punjabi_yatra.repository.customer.CustomerRepository;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class BookingMapper {

    private final CustomerRepository customerRepository;
    private final CabRepository cabRepository;

    public BookingMapper(CustomerRepository customerRepository, CabRepository cabRepository) {
        this.customerRepository = customerRepository;
        this.cabRepository = cabRepository;
    }

    public BookingDTO toDTO(Booking booking) {
        if (booking == null) {
            return null;
        }
        BookingDTO dto = new BookingDTO();
        dto.setId(booking.getId());
        dto.setPickupLocation(booking.getPickupLocation());
        dto.setDropLocation(booking.getDropLocation());
        dto.setBookingTime(booking.getBookingTime());
        dto.setStatus(booking.getStatus());
        dto.setFare(booking.getFare());

        if (booking.getCustomer() != null) {
            dto.setCustomerId(booking.getCustomer().getId());
            dto.setCustomerName(booking.getCustomer().getName());
        }
        if (booking.getCab() != null) {
            dto.setCabId(booking.getCab().getId());
            dto.setCabRegistrationNo(booking.getCab().getRegistration_no());
            if (booking.getCab().getDriver() != null) {
                dto.setDriverName(booking.getCab().getDriver().getName());
            }
        }
        return dto;
    }

    public Booking toEntity(BookingDTO dto) {
        if (dto == null) {
            return null;
        }
        Booking booking = new Booking();
        booking.setId(dto.getId());
        booking.setPickupLocation(dto.getPickupLocation());
        booking.setDropLocation(dto.getDropLocation());
        booking.setBookingTime(dto.getBookingTime() != null ? dto.getBookingTime() : LocalDateTime.now());
        booking.setStatus(dto.getStatus() != null ? dto.getStatus() : "PENDING");
        booking.setFare(dto.getFare());

        if (dto.getCustomerId() != null) {
            Customer customer = customerRepository.findById(dto.getCustomerId()).orElse(null);
            booking.setCustomer(customer);
        }
        if (dto.getCabId() != null) {
            Cab cab = cabRepository.findById(dto.getCabId()).orElse(null);
            booking.setCab(cab);
        }
        return booking;
    }

    public List<BookingDTO> toDTOList(List<Booking> bookings) {
        if (bookings == null) {
            return null;
        }
        return bookings.stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    public void updateEntityFromDTO(BookingDTO dto, Booking booking) {
        if (dto.getPickupLocation() != null) {
            booking.setPickupLocation(dto.getPickupLocation());
        }
        if (dto.getDropLocation() != null) {
            booking.setDropLocation(dto.getDropLocation());
        }
        if (dto.getStatus() != null) {
            booking.setStatus(dto.getStatus());
        }
        if (dto.getFare() != null) {
            booking.setFare(dto.getFare());
        }
    }
}

