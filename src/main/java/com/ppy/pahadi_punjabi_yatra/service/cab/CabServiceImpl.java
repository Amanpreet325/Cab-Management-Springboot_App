package com.ppy.pahadi_punjabi_yatra.service.cab;

import com.ppy.pahadi_punjabi_yatra.model.Cab;
import com.ppy.pahadi_punjabi_yatra.model.Driver;
import com.ppy.pahadi_punjabi_yatra.repository.cab.CabRepository;
import com.ppy.pahadi_punjabi_yatra.repository.driver.DriverRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

@Service
public class CabServiceImpl implements CabService {

    @Autowired
    private CabRepository cabRepository;
    @Autowired
    private DriverRepository driverRepository;

    @Override
    public List<Cab> getAvailableCabs(){


        return cabRepository.findByStatus("AVAILABLE");


    }

    @Override
    public Cab registerCabs(Cab cab){

        if(cabRepository.existsByRegistrationNo(cab.getRegistration_no())){
           throw new RuntimeException("Cab Exists by this Id");
        }
        return cabRepository.save(cab);
    }

@Override
public Cab getCabById(Long id) {
    return cabRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Cab not found"));
}

@Override

    public boolean assignDriverToCab(Long cabId,Long driverId){
        if(cabId==null || driverId==null){
            return false;
        }
        Optional<Cab> cabA=cabRepository.findById(cabId);
        Optional<Driver> driverA=driverRepository.findById(driverId);

           cabA.get().setDriver(driverA.get());
            driverA.get().setCab(cabA.get());
           cabRepository.save(cabA.get());

            driverRepository.save(driverA.get());
           return true;

}
@Override
    public List<Cab> getAllCabs(){
        List<Cab>c1=cabRepository.findAll();
        return c1;
}
}
