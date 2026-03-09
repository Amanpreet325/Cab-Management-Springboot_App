package com.ppy.pahadi_punjabi_yatra.model;

import jakarta.persistence.*;

import java.math.BigDecimal;
@Entity
@Table(name="driver")
public class Driver {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Column(name="phone_number")
    private String phoneNumber;
    @Column(name="license_number")
    private String licenseNumber;
    private BigDecimal rating;

    @OneToOne (mappedBy="driver")
    private Cab cab;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getLicenseNumber() {
        return licenseNumber;
    }

    public void setLicenseNumber(String licenseNumber) {
        this.licenseNumber = licenseNumber;
    }

    public BigDecimal getRating() {
        return rating;
    }

    public void setRating(BigDecimal rating) {
        this.rating = rating;
    }

    public Cab getCab() {
        return cab;
    }



    public void setCab(Cab cab) {
        this.cab = cab;
        if (cab != null && cab.getDriver() != this) {
            cab.setDriver(this);
        }
    }
}
