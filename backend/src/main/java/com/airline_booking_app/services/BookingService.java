package com.airline_booking_app.services;

import com.airline_booking_app.dto.BookingDTO;
import com.airline_booking_app.dto.CreateBookingRequest;
import com.airline_booking_app.dto.Response;
import com.airline_booking_app.enums.BookingStatus;

import java.util.List;

public interface BookingService {
    Response<?> createBooking(CreateBookingRequest createBookingRequest);
    Response<BookingDTO> getBookingById(Long id);
    Response<List<BookingDTO>> getAllBookings();
    Response<List<BookingDTO>> getMyBookings();
    Response<?> updateBookingStatus(Long id, BookingStatus status);
}
