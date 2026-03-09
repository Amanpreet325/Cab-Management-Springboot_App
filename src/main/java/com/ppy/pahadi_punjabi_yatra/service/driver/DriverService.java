package com.ppy.pahadi_punjabi_yatra.service.driver;

import com.ppy.pahadi_punjabi_yatra.model.Driver;

import java.util.List;
import java.util.Optional;

public interface DriverService {

   Driver addDriver(Driver driver);

   Optional<Driver> findByCabId(Long CabId);

   Optional<Driver> getDriverById(Long driverIdi);

   List<Driver> getAllDrivers();
}
