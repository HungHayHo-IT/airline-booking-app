package com.airline_booking_app.services;

import com.airline_booking_app.dto.CreateFlightRequest;
import com.airline_booking_app.dto.FlightDTO;
import com.airline_booking_app.dto.Response;
import com.airline_booking_app.enums.City;
import com.airline_booking_app.enums.Country;
import com.airline_booking_app.enums.FlightStatus;

import java.time.LocalDate;
import java.util.List;

public interface FlightService {

    Response<?> createFlight(CreateFlightRequest createFlightRequest);
    Response<FlightDTO> getFlightById(Long id);
    Response<List<FlightDTO>> getAllFlights();
    Response<?> updateFlight(CreateFlightRequest createFlightRequest);
    Response<List<FlightDTO>> searchFlight(String departurePortIata, String arrivalPortIata, FlightStatus status, LocalDate departureDate);
    Response<List<City>> getAllCities();
    Response<List<Country>> getAllCountries();

}
