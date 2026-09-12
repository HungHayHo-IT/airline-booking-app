package com.airline_booking_app.repo;

import com.airline_booking_app.entity.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookingRepo extends JpaRepository<Booking, Long> {

    List<Booking> findByUserIdOrderByIdDesc(Long userId);
}

