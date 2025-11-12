package com.example.usefy.service;

import com.example.usefy.config.SecurityConfig;
import com.example.usefy.model.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    private final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
    @Override
    public void registerUser(User newUser) {
        User user = new User();
        user.setId(newUser.getId());
        user.setUsername(newUser.getUsername());
        user.setPassword(encoder.encode(newUser.getPassword()));
    }

    @Override
    public User findUserByUsername(String username) {
        return null;
    }
}
