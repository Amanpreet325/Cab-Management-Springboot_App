package com.ppy.pahadi_punjabi_yatra.mapper;

import com.ppy.pahadi_punjabi_yatra.dto.CabDTO;
import com.ppy.pahadi_punjabi_yatra.model.Cab;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class CabMapper {

    private final DriverMapper driverMapper;

    public CabMapper(DriverMapper driverMapper) {
        this.driverMapper = driverMapper;
    }

    public CabDTO toDTO(Cab cab) {
        if (cab == null) {
            return null;
        }
        CabDTO dto = new CabDTO();
        dto.setId(cab.getId());
        dto.setRegistrationNo(cab.getRegistration_no());
        dto.setModel(cab.getModel());
        dto.setStatus(cab.getStatus());
        if (cab.getDriver() != null) {
            dto.setDriver(driverMapper.toDTO(cab.getDriver()));
        }
        return dto;
    }

    public Cab toEntity(CabDTO dto) {
        if (dto == null) {
            return null;
        }
        Cab cab = new Cab();
        cab.setId(dto.getId());
        cab.setRegistration_no(dto.getRegistrationNo());
        cab.setModel(dto.getModel());
        cab.setStatus(dto.getStatus() != null ? dto.getStatus() : "AVAILABLE");
        return cab;
    }

    public List<CabDTO> toDTOList(List<Cab> cabs) {
        if (cabs == null) {
            return null;
        }
        return cabs.stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    public void updateEntityFromDTO(CabDTO dto, Cab cab) {
        if (dto.getRegistrationNo() != null) {
            cab.setRegistration_no(dto.getRegistrationNo());
        }
        if (dto.getModel() != null) {
            cab.setModel(dto.getModel());
        }
        if (dto.getStatus() != null) {
            cab.setStatus(dto.getStatus());
        }
    }
}

