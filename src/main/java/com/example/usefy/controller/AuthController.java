package com.example.usefy.controller;

import com.example.usefy.model.User;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {

    @PostMapping("/auth/register")
    public void registerUser(User user){

    }

    @PostMapping("/auth/login")
    public void login(User user){

    }
}
