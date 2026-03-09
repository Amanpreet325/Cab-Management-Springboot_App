package com.ppy.pahadi_punjabi_yatra.dto;

import jakarta.validation.constraints.*;
import java.math.BigDecimal;

public class DriverDTO {

    private Long id;

    @NotBlank(message = "Driver name is required")
    @Size(min = 2, max = 100, message = "Name must be between 2 and 100 characters")
    @Pattern(regexp = "^[a-zA-Z\\s]+$", message = "Name can only contain letters and spaces")
    private String name;

    @NotBlank(message = "Phone number is required")

    private String phoneNumber;

    @NotBlank(message = "License number is required")

    private String licenseNumber;

    @DecimalMin(value = "0.0", message = "Rating cannot be negative")
    @DecimalMax(value = "5.0", message = "Rating cannot exceed 5.0")
    private BigDecimal rating;

    private Long cabId;

    // Getters
    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getLicenseNumber() {
        return licenseNumber;
    }

    public BigDecimal getRating() {
        return rating;
    }

    public Long getCabId() {
        return cabId;
    }

    // Setters
    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setLicenseNumber(String licenseNumber) {
        this.licenseNumber = licenseNumber;
    }

    public void setRating(BigDecimal rating) {
        this.rating = rating;
    }

    public void setCabId(Long cabId) {
        this.cabId = cabId;
    }
}
