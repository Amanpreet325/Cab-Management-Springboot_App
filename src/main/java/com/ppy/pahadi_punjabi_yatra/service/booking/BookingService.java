package com.ppy.pahadi_punjabi_yatra.service.booking;

import com.ppy.pahadi_punjabi_yatra.model.Booking;
import com.ppy.pahadi_punjabi_yatra.model.Cab;

import java.util.List;

public interface BookingService {

    Booking bookCab(Booking booking);

    List<Booking> getAllBookings();
}
