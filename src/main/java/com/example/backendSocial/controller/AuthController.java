package com.example.backendSocial.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.backendSocial.Entity.User;
import com.example.backendSocial.config.jwtProvider;
import com.example.backendSocial.models.LoginRequest;
import com.example.backendSocial.repositories.UserRepository;
import com.example.backendSocial.response.AuthResponse;
import com.example.backendSocial.services.CustomUserService;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private CustomUserService customUserService;

    @GetMapping("/")
    public String home() {
        return "Welcome to the home page";
    }

    @PostMapping("/signup")
    public AuthResponse RegisterUser(@RequestBody User user) {

        User isUserExist = userRepository.findByEmail(user.getEmail());

        if (isUserExist != null) {
            throw new BadCredentialsException("User already exist");
        }

        User newUser = new User();

        newUser.setFirstName(user.getFirstName());
        newUser.setLastName(user.getLastName());
        newUser.setEmail(user.getEmail());
        newUser.setPassword(passwordEncoder.encode(user.getPassword()));
        newUser.setRole(user.getRole());
        newUser.setAdharNumber(user.getAdharNumber());
        newUser.setDistrict(user.getDistrict());
        newUser.setPhoneNumber(user.getPhoneNumber());
        newUser.setState(user.getState());
        newUser.setLocation(user.getLocation());
        newUser.setProfilePicture(user.getProfilePicture());

        User savedUser = userRepository.save(newUser);

        Authentication authentication = new UsernamePasswordAuthenticationToken(savedUser.getEmail(),
                savedUser.getPassword());

        String token = jwtProvider.generateToken(authentication);

        AuthResponse authResponse = new AuthResponse(token, "User registered successfully");

        return authResponse;
    }

    @PostMapping("/login")
    public AuthResponse LoginUser(@RequestBody LoginRequest loginRequest) {

        Authentication authentication = authentication(loginRequest.getEmail(), loginRequest.getPassword());

        String token = jwtProvider.generateToken(authentication);

        AuthResponse authResponse = new AuthResponse(token, "User logged in successfully");

        return authResponse;

    }

    private Authentication authentication(String email, String password) throws BadCredentialsException {

        UserDetails user = customUserService
                .loadUserByUsername(email);

        if (user == null) {
            throw new BadCredentialsException("User not found");
        }

        if (!passwordEncoder.matches(password, user.getPassword())) {
            throw new BadCredentialsException("Invalid password");
        }

        Authentication authentication = new UsernamePasswordAuthenticationToken(user, null, user.getAuthorities());

        return authentication;
    }

}
