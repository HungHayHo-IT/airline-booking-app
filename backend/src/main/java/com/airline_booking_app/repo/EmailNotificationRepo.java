package com.airline_booking_app.repo;

import com.airline_booking_app.entity.EmailNotification;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmailNotificationRepo extends JpaRepository<EmailNotification, Long> {
}
