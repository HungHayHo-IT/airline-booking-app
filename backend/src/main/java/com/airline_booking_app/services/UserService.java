package com.airline_booking_app.services;


import com.airline_booking_app.dto.Response;
import com.airline_booking_app.dto.UserDTO;
import com.airline_booking_app.entity.User;

import java.util.List;

public interface UserService {

    User currentUser();

    Response<?> updateMyAccount(UserDTO userDTO);

    Response<List<UserDTO>> getAllPilots();

    Response<UserDTO> getAccountDetails();
}
