package com.example.usefy.controller;

import com.example.usefy.model.User;
import com.example.usefy.service.UserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {
    private UserService userService;

    public AuthController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/auth/register")
    public void registerUser(User user){
        userService.registerUser(user);
    }

    @PostMapping("/auth/login")
    public void login(User user){
        userService.findUserByUsername(user.getUsername());
        //TODO complete all functions
    }
}
