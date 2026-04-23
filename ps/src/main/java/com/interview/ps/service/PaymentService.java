package com.interview.ps.service;

import com.interview.ps.dto.MakePayment;
import com.interview.ps.entity.Booking;
import com.interview.ps.entity.Flight;
import com.interview.ps.entity.Payment;
import com.interview.ps.entity.Users;
import com.interview.ps.repository.BookingRepository;
import com.interview.ps.repository.FlightRepository;
import com.interview.ps.repository.PaymentRepository;
import com.interview.ps.repository.UserDetailsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.awt.print.Book;

@Service
@RequiredArgsConstructor
public class PaymentService {

    private final PaymentRepository paymentRepository;
    private final BookingRepository bookingRepository;
    private final FlightRepository flightRepository;
    private final UserDetailsRepository userDetailsRepository;


    public void addPaymentDetails(MakePayment makePayment)
    {
        Payment payment = new Payment();
        payment.setPaymentMode(makePayment.getPaymentMode());
        payment.setPaymentDetails(makePayment.getPaymentDetails());
        payment.setBalance(makePayment.getBalance());
        Users user = userDetailsRepository.findById(makePayment.getUserId())
                        .orElseThrow(()->new RuntimeException("User not found"));

        payment.setUsers(user);

        Booking b = bookingRepository.findById(makePayment.getBookingId())
                        .orElseThrow(()->new RuntimeException("Booking not done"));
        payment.setBooking(b);

        paymentRepository.save(payment);

    }

    public void makePayment(Long id) {
        Booking b = bookingRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("Booking not done"));

        if(b.getBookingStatus().equals("BOOKED")) {

            Payment p = b.getPayment();
            Flight f = b.getFlight();
            p.setBalance(p.getBalance() - f.getCurrentPrice());
            p.setPaymentStatus("SUCCESSFUL");

            paymentRepository.save(p);
        }
        else
        {
            throw new RuntimeException("Payment failed");
        }
    }
}
