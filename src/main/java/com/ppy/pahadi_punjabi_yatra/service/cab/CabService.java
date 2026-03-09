package com.ppy.pahadi_punjabi_yatra.service.cab;

import com.ppy.pahadi_punjabi_yatra.model.Cab;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public interface CabService {

    boolean assignDriverToCab(Long cabId,Long driverId);
    
    List<Cab> getAvailableCabs();
    Cab registerCabs(Cab cab);

    Cab getCabById(Long cabId);

    List<Cab> getAllCabs();
}
