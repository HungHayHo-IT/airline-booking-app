package com.airline_booking_app;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
public class AirlineBookingAppApplication {



	public static void main(String[] args) {
		SpringApplication.run(AirlineBookingAppApplication.class, args);
	}


}
