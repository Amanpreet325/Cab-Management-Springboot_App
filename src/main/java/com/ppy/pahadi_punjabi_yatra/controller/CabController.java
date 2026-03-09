package com.ppy.pahadi_punjabi_yatra.controller;

import com.ppy.pahadi_punjabi_yatra.dto.CabDTO;
import com.ppy.pahadi_punjabi_yatra.dto.DriverDTO;
import com.ppy.pahadi_punjabi_yatra.mapper.CabMapper;
import com.ppy.pahadi_punjabi_yatra.model.Cab;
import com.ppy.pahadi_punjabi_yatra.model.Driver;
import com.ppy.pahadi_punjabi_yatra.service.cab.CabService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cabs")
public class CabController {

    private final CabService cabService;
    private final CabMapper cabMapper;

    public CabController(CabService cabService, CabMapper cabMapper) {
        this.cabService = cabService;
        this.cabMapper = cabMapper;
    }

    @PostMapping
    public ResponseEntity<CabDTO> registerCab(@Valid @RequestBody CabDTO cabDTO) {
        Cab cab = cabMapper.toEntity(cabDTO);
        Cab savedCab = cabService.registerCabs(cab);
        return ResponseEntity.status(HttpStatus.CREATED).body(cabMapper.toDTO(savedCab));
    }
    @GetMapping
    public ResponseEntity<List<Cab>> getAllCabs(){
        List<Cab> cabs=cabService.getAllCabs();
        return new ResponseEntity<>(cabs, HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> getCabById(@PathVariable Long id) {
        Cab cab = cabService.getCabById(id);
        if (cab == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(cabMapper.toDTO(cab));
    }

    @GetMapping("/available")
    public ResponseEntity<List<CabDTO>> getAvailableCabs() {
        List<Cab> cabs = cabService.getAvailableCabs();
        return ResponseEntity.ok(cabMapper.toDTOList(cabs));
    }

    @PostMapping("/{cabId}/assign-driver/{driverId}")
    public ResponseEntity<String> assignDriverToCab(
            @PathVariable Long cabId,
            @PathVariable Long driverId) {
        boolean success = cabService.assignDriverToCab(cabId, driverId);
        if (success) {
            return ResponseEntity.ok("Driver assigned to cab successfully");
        }
        return ResponseEntity.badRequest().body("Failed to assign driver to cab");
    }
}

