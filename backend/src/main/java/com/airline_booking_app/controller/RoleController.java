package com.airline_booking_app.controller;

import com.airline_booking_app.dto.Response;
import com.airline_booking_app.dto.RoleDTO;
import com.airline_booking_app.services.RoleService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/roles")
@RequiredArgsConstructor
public class RoleController {

    private final RoleService roleService;


    @PostMapping
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<Response<?>> createRole(@Valid @RequestBody RoleDTO roleDTO){
        return ResponseEntity.ok(roleService.createRole(roleDTO));
    }

    @PutMapping
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<Response<?>> updateRole( @Valid @RequestBody RoleDTO roleDTO){
        return ResponseEntity.ok(roleService.updateRole(roleDTO));
    }

    @GetMapping
    @PreAuthorize("hasAnyAuthority('ADMIN', 'PILOT')")
    public  ResponseEntity<Response<?>> getAllRoles(){
        return ResponseEntity.ok(roleService.getAllRoles());
    }


}