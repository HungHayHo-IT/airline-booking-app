package com.airline_booking_app.services.impl;

import com.airline_booking_app.dto.LoginRequest;
import com.airline_booking_app.dto.LoginResponse;
import com.airline_booking_app.dto.RegistrationRequest;
import com.airline_booking_app.dto.Response;
import com.airline_booking_app.entity.Role;
import com.airline_booking_app.entity.User;
import com.airline_booking_app.enums.AuthMethod;
import com.airline_booking_app.exception.BadRequestException;
import com.airline_booking_app.exception.NotFoundException;
import com.airline_booking_app.repo.RoleRepo;
import com.airline_booking_app.repo.UserRepo;
import com.airline_booking_app.security.JwtUtils;
import com.airline_booking_app.services.AuthService;
import com.airline_booking_app.services.EmailNotificationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {


    private final UserRepo userRepo;
    private final PasswordEncoder passwordEncoder;
    private final JwtUtils jwtUtils;
    private final RoleRepo roleRepo;
    private final EmailNotificationService emailNotificationService;


    @Override
    public Response<?> register(RegistrationRequest registrationRequest) {
        log.info("Inside register()");
        if (userRepo.existsByEmail(registrationRequest.getEmail())){
            throw new BadRequestException("Email already exist");
        }

        List<Role> userRoles;

        if (registrationRequest.getRoles() != null && !registrationRequest.getRoles().isEmpty()){
            userRoles = registrationRequest.getRoles().stream()
                    .map(roleName -> roleRepo.findByName(roleName.toUpperCase())
                            .orElseThrow(()-> new NotFoundException("Role " + roleName + "Not Found")))
                    .toList();
        }else{
            Role defaultRole = roleRepo.findByName("CUSTOMER")
                    .orElseThrow(()-> new NotFoundException("Role CUSTOMER DOESN'T EXISTS"));
            userRoles = List.of(defaultRole);
        }

        User userToSave = new User();
        userToSave.setName(registrationRequest.getName());
        userToSave.setEmail(registrationRequest.getEmail());
        userToSave.setPhoneNumber(registrationRequest.getPhoneNumber());
        userToSave.setPassword(passwordEncoder.encode(registrationRequest.getPassword()));
        userToSave.setRoles(userRoles);
        userToSave.setCreatedAt(LocalDateTime.now());
        userToSave.setUpdatedAt(LocalDateTime.now());
        userToSave.setProvider(AuthMethod.LOCAL);
        userToSave.setActive(true);

        User savedUser = userRepo.save(userToSave);

        emailNotificationService.sendWelcomeEmail(savedUser);

        return Response.builder()
                .statusCode(HttpStatus.OK.value())
                .message("user registered sucessfully")
                .build();
    }

    @Override
    public Response<LoginResponse> login(LoginRequest loginRequest) {

        log.info("Inside login()");
        User user = userRepo.findByEmail(loginRequest.getEmail())
                .orElseThrow(()-> new NotFoundException("Email Not Found"));

        if (!user.isActive()){
            throw new NotFoundException("Acount Not Active, Please reach Out to Customer Care...");
        }
        if (!passwordEncoder.matches(loginRequest.getPassword(), user.getPassword())){
            throw new BadRequestException("Invalid Password");
        }

        String token = jwtUtils.generateToken(user.getEmail());

        List<String > roleNames = user.getRoles().stream()
                .map(Role::getName)
                .toList();

        LoginResponse loginResponse = new LoginResponse();
        loginResponse.setToken(token);
        loginResponse.setRoles(roleNames);

        return Response.<LoginResponse>builder()
                .statusCode(HttpStatus.OK.value())
                .message("Login Successful")
                .data(loginResponse)
                .build();
    }
}

