package com.ppy.pahadi_punjabi_yatra.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Cab {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "registration_no")
    private String registrationNo;  //findByRegistrationNo
    private String  model;
    private String status;

    @OneToOne
     @JoinColumn(name = "driver_id",unique = true)
    private Driver driver;
    @OneToMany(mappedBy = "cab")
    private List<Booking> bookings;

    public Long getId() {
        return id;
    }

    public String getRegistration_no() {
        return registrationNo;
    }

    public String getModel() {
        return model;
    }

    public String getStatus() {
        return status;
    }

    public Driver getDriver() {
        return driver;
    }

    public List<Booking> getBookings() {
        return bookings;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setRegistration_no(String registrationNo) {
        this.registrationNo = registrationNo;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setBookings(List<Booking> bookings) {
        this.bookings = bookings;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }
}
