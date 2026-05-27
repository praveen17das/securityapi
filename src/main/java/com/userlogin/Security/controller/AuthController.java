package com.userlogin.Security.controller;

import com.userlogin.Security.dto.*;
import com.userlogin.Security.entity.UserEntity;
import com.userlogin.Security.security.JwtUtil;
import com.userlogin.Security.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.
        AuthenticationManager;
import org.springframework.security.authentication.
        UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private UserService userService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtUtil jwtUtil;

    // REGISTER
    @PostMapping("/register")
    public UserEntity register(
            @RequestBody UserEntity user) {

        return userService.registerUser(user);
    }

    // LOGIN
    @PostMapping("/login")
    public AuthResponse login(
            @RequestBody AuthRequest request) {

        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getUsername(),
                        request.getPassword()
                )
        );

        String token =
                jwtUtil.generateToken(request.getUsername());

        return new AuthResponse(token);
    }
}