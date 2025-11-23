package com.example.usefy.service;

import com.example.usefy.dto.UserRegistrationDto;
import com.example.usefy.model.User;
import com.example.usefy.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class UserServiceImpl implements UserService {
    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;

    public UserServiceImpl(PasswordEncoder passwordEncoder, UserRepository userRepository) {
        this.passwordEncoder = passwordEncoder;
        this.userRepository = userRepository;
    }

    @Override
    public User registerUser(UserRegistrationDto userRegistrationDto) {
        if (userRepository.findByUsername(userRegistrationDto.getUsername()) != null) {
            throw new IllegalArgumentException("Username already exists.");
        }
        String hashedPassword = passwordEncoder.encode(userRegistrationDto.getPassword());
        User user = new User(userRegistrationDto.getUsername(), hashedPassword);
        return userRepository.save(user);
    }

    @Override
    public User findByUsername(String username) {
        return userRepository.findByUsername(username).
                orElseThrow( () -> new NoSuchElementException("No user found"));
    }
}