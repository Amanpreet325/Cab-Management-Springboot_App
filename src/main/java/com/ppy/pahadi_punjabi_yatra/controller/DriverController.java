package com.ppy.pahadi_punjabi_yatra.controller;

import com.ppy.pahadi_punjabi_yatra.dto.DriverDTO;
import com.ppy.pahadi_punjabi_yatra.mapper.DriverMapper;
import com.ppy.pahadi_punjabi_yatra.model.Cab;
import com.ppy.pahadi_punjabi_yatra.model.Driver;
import com.ppy.pahadi_punjabi_yatra.service.driver.DriverService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/drivers")
public class DriverController {

    private final DriverService driverService;
    private final DriverMapper driverMapper;

    public DriverController(DriverService driverService, DriverMapper driverMapper) {
        this.driverService = driverService;
        this.driverMapper = driverMapper;
    }

    @PostMapping
    public ResponseEntity<DriverDTO> addDriver(@Valid @RequestBody DriverDTO driverDTO) {
        Driver driver = driverMapper.toEntity(driverDTO);
        Driver savedDriver = driverService.addDriver(driver);
        return ResponseEntity.status(HttpStatus.CREATED).body(driverMapper.toDTO(savedDriver));
    }
    @GetMapping
    public ResponseEntity<List<Driver>> getAllDrivers() {
        List<Driver> drivers = driverService.getAllDrivers();
        return new ResponseEntity<>(drivers,HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getDriverById(@PathVariable Long id) {
        Optional<Driver> driver = driverService.getDriverById(id);
        if (driver.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(driverMapper.toDTO(driver.get()));
    }

    @GetMapping("/by-cab/{cabId}")
    public ResponseEntity<?> getDriverByCabId(@PathVariable Long cabId) {
        Optional<Driver> driver = driverService.findByCabId(cabId);
        if (driver.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(driverMapper.toDTO(driver.get()));
    }
}

