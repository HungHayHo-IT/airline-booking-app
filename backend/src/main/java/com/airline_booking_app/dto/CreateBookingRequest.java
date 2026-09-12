package com.airline_booking_app.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.util.List;

public class CreateBookingRequest {

    @NotNull(message = "Flight ID cannot be null")
    private Long flightId;

    @NotEmpty(message = "At least one passenger must be provided")
    private List<PassengerDTO> passengers;
}
