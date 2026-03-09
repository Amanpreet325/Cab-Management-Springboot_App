package com.ppy.pahadi_punjabi_yatra.mapper;

import com.ppy.pahadi_punjabi_yatra.dto.DriverDTO;
import com.ppy.pahadi_punjabi_yatra.model.Driver;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class DriverMapper {

    public DriverDTO toDTO(Driver driver) {
        if (driver == null) {
            return null;
        }
        DriverDTO dto = new DriverDTO();
        dto.setId(driver.getId());
        dto.setName(driver.getName());
        dto.setPhoneNumber(driver.getPhoneNumber());
        dto.setLicenseNumber(driver.getLicenseNumber());
        dto.setRating(driver.getRating());
        if (driver.getCab() != null) {
            dto.setCabId(driver.getCab().getId());
        }
        return dto;
    }

    public Driver toEntity(DriverDTO dto) {
        if (dto == null) {
            return null;
        }
        Driver driver = new Driver();
        driver.setId(dto.getId());
        driver.setName(dto.getName());
        driver.setPhoneNumber(dto.getPhoneNumber());
        driver.setLicenseNumber(dto.getLicenseNumber());
        driver.setRating(dto.getRating());
        return driver;
    }

    public List<DriverDTO> toDTOList(List<Driver> drivers) {
        if (drivers == null) {
            return null;
        }
        return drivers.stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    public void updateEntityFromDTO(DriverDTO dto, Driver driver) {
        if (dto.getName() != null) {
            driver.setName(dto.getName());
        }
        if (dto.getPhoneNumber() != null) {
            driver.setPhoneNumber(dto.getPhoneNumber());
        }
        if (dto.getLicenseNumber() != null) {
            driver.setLicenseNumber(dto.getLicenseNumber());
        }
        if (dto.getRating() != null) {
            driver.setRating(dto.getRating());
        }
    }
}

