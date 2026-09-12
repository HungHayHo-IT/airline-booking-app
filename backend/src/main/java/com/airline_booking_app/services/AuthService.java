package com.airline_booking_app.services;

import com.airline_booking_app.dto.LoginRequest;
import com.airline_booking_app.dto.LoginResponse;
import com.airline_booking_app.dto.RegistrationRequest;
import com.airline_booking_app.dto.Response;

public interface AuthService {
    Response<?> register(RegistrationRequest registrationRequest);
    Response<LoginResponse> login(LoginRequest loginRequest);
}
