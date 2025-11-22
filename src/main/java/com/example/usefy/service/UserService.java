package com.example.usefy.service;

import com.example.usefy.dto.UserRegistrationDto;
import com.example.usefy.model.User;
import org.springframework.stereotype.Service;

@Service
public interface UserService {
    User registerUser(UserRegistrationDto userRegistrationDto) throws IllegalArgumentException;
    User findByUsername(String username);
}
