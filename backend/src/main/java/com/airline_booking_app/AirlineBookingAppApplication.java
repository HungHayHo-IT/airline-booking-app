package com.airline_booking_app;

import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.EnableAsync;

import java.nio.charset.StandardCharsets;

@SpringBootApplication
@EnableAsync
public class AirlineBookingAppApplication {



	public static void main(String[] args) {
		SpringApplication.run(AirlineBookingAppApplication.class, args);
	}


}
