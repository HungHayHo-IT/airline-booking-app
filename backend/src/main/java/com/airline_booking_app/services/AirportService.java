package com.airline_booking_app.services;

import com.airline_booking_app.dto.AirportDTO;
import com.airline_booking_app.dto.Response;

import java.util.List;

public interface AirportService {

    Response<?> createAirport(AirportDTO airportDTO);

    Response<?> updateAirport(AirportDTO airportDTO);

    Response<List<AirportDTO>> getAllAirports();

    Response<AirportDTO> getAirportById(Long id);

}
