package com.ppy.pahadi_punjabi_yatra.controller;

import com.ppy.pahadi_punjabi_yatra.dto.BookingDTO;
import com.ppy.pahadi_punjabi_yatra.mapper.BookingMapper;
import com.ppy.pahadi_punjabi_yatra.model.Booking;
import com.ppy.pahadi_punjabi_yatra.model.Cab;
import com.ppy.pahadi_punjabi_yatra.service.booking.BookingService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/bookings")
public class BookingController {

    private final BookingService bookingService;
    private final BookingMapper bookingMapper;

    public BookingController(BookingService bookingService, BookingMapper bookingMapper) {
        this.bookingService = bookingService;
        this.bookingMapper = bookingMapper;
    }

    @PostMapping
    public ResponseEntity<BookingDTO> createBooking(@Valid @RequestBody BookingDTO bookingDTO) {
        Booking booking = bookingMapper.toEntity(bookingDTO);
        Booking savedBooking = bookingService.bookCab(booking);
        return ResponseEntity.status(HttpStatus.CREATED).body(bookingMapper.toDTO(savedBooking));
    }
    @GetMapping
    public ResponseEntity<List<Booking>> getAllBookings(){
        List<Booking> books=bookingService.getAllBookings();
        return new ResponseEntity<>(books, HttpStatus.OK);
    }
}

