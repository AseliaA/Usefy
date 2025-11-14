package com.example.usefy.controller;

import com.example.usefy.model.User;
import com.example.usefy.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {
    private final UserService userService;
    private final PasswordEncoder passwordEncoder;

    public AuthController(UserService userService, PasswordEncoder passwordEncoder) {
        this.userService = userService;
        this.passwordEncoder = passwordEncoder;
    }

    @PostMapping("/register")
    @ResponseStatus(HttpStatus.CREATED)
    public void registerUser(User user){
        userService.registerUser(user);
    }

    @PostMapping("/login")
    public void login(String username, String rawPassword){
        User user = userService.findByUsername(username);
        if (user != null) {
            String encodedPassword = user.getPassword();
            passwordEncoder.matches(rawPassword, encodedPassword);
        }
        //TODO complete logic and checks later
    }
}
