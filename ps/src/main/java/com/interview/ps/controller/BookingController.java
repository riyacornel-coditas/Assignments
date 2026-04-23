package com.interview.ps.controller;

import com.interview.ps.dto.AddTotalSeats;
import com.interview.ps.dto.BookFlight;
import com.interview.ps.repository.BookingRepository;
import com.interview.ps.service.BookingService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/booking")
@RequiredArgsConstructor
public class BookingController {

    private final BookingService bookingService;

    @PostMapping("/make")
    public String makeBooking(@RequestBody BookFlight bookFlight)
    {
        bookingService.bookFlight(bookFlight);
        return "BOOKED";
    }
}
