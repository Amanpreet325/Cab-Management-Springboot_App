package com.ppy.pahadi_punjabi_yatra.service.driver;

import com.ppy.pahadi_punjabi_yatra.model.Cab;
import com.ppy.pahadi_punjabi_yatra.model.Driver;
import com.ppy.pahadi_punjabi_yatra.repository.driver.DriverRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DriverServiceImpl implements DriverService{
    @Autowired
    private DriverRepository driverRepository;

    @Override
    public Driver addDriver(Driver driver) {
        if(driverRepository.existsByLicenseNumber(driver.getLicenseNumber())){
            throw new RuntimeException("Driver Already Exists");
        }
        return driverRepository.save(driver);
    }

    @Override
    public Optional<Driver> findByCabId(Long CabId){
        if (CabId == null) {
            return Optional.empty();
        }
        return driverRepository.findByCab_Id(CabId);
    }
    @Override
    public Optional<Driver> getDriverById(Long driverIdi){
        return driverRepository.findById(driverIdi);

    }

    @Override
    public List<Driver> getAllDrivers() {
        return driverRepository.findAll();
    }

}
