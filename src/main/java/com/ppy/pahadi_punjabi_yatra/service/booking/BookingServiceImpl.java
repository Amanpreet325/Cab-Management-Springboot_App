package com.ppy.pahadi_punjabi_yatra.service.booking;

import com.ppy.pahadi_punjabi_yatra.model.Booking;
import com.ppy.pahadi_punjabi_yatra.repository.booking.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookingServiceImpl implements BookingService{

    @Autowired
    private BookingRepository bookingRepository;

    @Override
    public Booking bookCab(Booking booking){
        // For new bookings, the ID will be auto-generated, so we don't need to check existence
        // Just save the booking directly
        return bookingRepository.save(booking);
    }
    @Override
    public List<Booking> getAllBookings(){
        return bookingRepository.findAll();
    }
}
