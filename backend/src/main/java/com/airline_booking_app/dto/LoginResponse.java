package com.airline_booking_app.dto;

import lombok.Data;

import java.util.List;

@Data
public class LoginResponse {

    private String token;
    private List<String> roles;
}
