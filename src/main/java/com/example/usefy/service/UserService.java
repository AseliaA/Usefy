package com.example.usefy.service;

import com.example.usefy.model.User;
import org.springframework.stereotype.Service;

@Service
public interface UserService {
    User registerUser(User user);
    User findByUsername(String username);
}
