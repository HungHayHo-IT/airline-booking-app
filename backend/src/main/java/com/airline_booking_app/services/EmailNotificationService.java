package com.airline_booking_app.services;

import com.airline_booking_app.entity.Booking;
import com.airline_booking_app.entity.User;

import org.springframework.stereotype.Service;


@Service
public interface EmailNotificationService {

    void sendBookingTickerEmail(Booking booking);
    void sendWelcomeEmail(User user);

}
