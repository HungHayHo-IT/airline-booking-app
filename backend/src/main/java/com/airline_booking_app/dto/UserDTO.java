package com.airline_booking_app.dto;

import com.airline_booking_app.enums.AuthMethod;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {

    private Long id;

    private String name;

    private String email;

    private String phoneNumber;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;

    private Boolean emailVerified;


    private AuthMethod provider;
    private String providerId;

    private List<RoleDTO> roles;

    private Boolean active;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;
}
