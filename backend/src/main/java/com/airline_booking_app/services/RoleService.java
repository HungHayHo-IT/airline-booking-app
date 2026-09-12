package com.airline_booking_app.services;

import com.airline_booking_app.dto.Response;
import com.airline_booking_app.dto.RoleDTO;
import java.util.List;


public interface RoleService {
    Response<?> createRole(RoleDTO roleDTO);
    Response<?> updateRole(RoleDTO roleDTO);
    Response<List<RoleDTO>> getAllRoles();
}
