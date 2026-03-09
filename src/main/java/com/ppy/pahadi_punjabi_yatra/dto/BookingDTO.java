package com.ppy.pahadi_punjabi_yatra.dto;

import jakarta.validation.constraints.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

public class BookingDTO {

    private Long id;

    @NotNull(message = "Customer ID is required")
    private Long customerId;

    @NotNull(message = "Cab ID is required")
    private Long cabId;

    @NotBlank(message = "Pickup location is required")
    @Size(min = 3, max = 200, message = "Pickup location must be between 3 and 200 characters")
    private String pickupLocation;

    @NotBlank(message = "Drop location is required")
    @Size(min = 3, max = 200, message = "Drop location must be between 3 and 200 characters")
    private String dropLocation;

    private LocalDateTime bookingTime;

    @Pattern(regexp = "^(PENDING|CONFIRMED|COMPLETED|CANCELLED)$", message = "Status must be PENDING, CONFIRMED, COMPLETED, or CANCELLED")
    private String status;

    @DecimalMin(value = "0.0", message = "Fare cannot be negative")
    private BigDecimal fare;

    private String customerName;
    private String cabRegistrationNo;
    private String driverName;

    // Getters
    public Long getId() {
        return id;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public Long getCabId() {
        return cabId;
    }

    public String getPickupLocation() {
        return pickupLocation;
    }

    public String getDropLocation() {
        return dropLocation;
    }

    public LocalDateTime getBookingTime() {
        return bookingTime;
    }

    public String getStatus() {
        return status;
    }

    public BigDecimal getFare() {
        return fare;
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getCabRegistrationNo() {
        return cabRegistrationNo;
    }

    public String getDriverName() {
        return driverName;
    }

    // Setters
    public void setId(Long id) {
        this.id = id;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public void setCabId(Long cabId) {
        this.cabId = cabId;
    }

    public void setPickupLocation(String pickupLocation) {
        this.pickupLocation = pickupLocation;
    }

    public void setDropLocation(String dropLocation) {
        this.dropLocation = dropLocation;
    }

    public void setBookingTime(LocalDateTime bookingTime) {
        this.bookingTime = bookingTime;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setFare(BigDecimal fare) {
        this.fare = fare;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public void setCabRegistrationNo(String cabRegistrationNo) {
        this.cabRegistrationNo = cabRegistrationNo;
    }

    public void setDriverName(String driverName) {
        this.driverName = driverName;
    }
}
