package com.airline_booking_app.repo;

import com.airline_booking_app.entity.Flight;
import com.airline_booking_app.enums.FlightStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface FlightRepo extends JpaRepository<Flight, Long> {

    boolean existsByFlightNumber(String flightNumber);

    List<Flight> findByDepartureAirportIataCodeAndArrivalAirportIataCodeAndStatusAndDepartureTimeBetween(
            String departureIataCode, String arrivalIataCode, FlightStatus status, LocalDateTime startOfDay, LocalDateTime endOfDay);


}
