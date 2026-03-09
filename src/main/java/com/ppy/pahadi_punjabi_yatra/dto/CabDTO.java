package com.ppy.pahadi_punjabi_yatra.dto;

import jakarta.validation.constraints.*;

public class CabDTO {

    private Long id;

    @NotBlank(message = "Registration number is required")

    private String registrationNo;

    @NotBlank(message = "Model is required")
    @Size(min = 2, max = 50, message = "Model must be between 2 and 50 characters")
    private String model;

    @NotBlank(message = "Status is required")
    @Pattern(regexp = "^(AVAILABLE|BOOKED|MAINTENANCE)$", message = "Status must be AVAILABLE, BOOKED, or MAINTENANCE")
    private String status;

    private DriverDTO driver;

    // Getters
    public Long getId() {
        return id;
    }

    public String getRegistrationNo() {
        return registrationNo;
    }

    public String getModel() {
        return model;
    }

    public String getStatus() {
        return status;
    }

    public DriverDTO getDriver() {
        return driver;
    }

    // Setters
    public void setId(Long id) {
        this.id = id;
    }

    public void setRegistrationNo(String registrationNo) {
        this.registrationNo = registrationNo;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setDriver(DriverDTO driver) {
        this.driver = driver;
    }
}
