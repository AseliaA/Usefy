package com.example.usefy.service;

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
    public User registerUser(User user) {
        if (userRepository.findByUsername(user.getUsername()).isEmpty()) {
            throw new IllegalArgumentException("Username already exists");
        } else {
            User newUser = new User();
            String encodedPassword = passwordEncoder.encode(user.getPassword());
            newUser.setUsername(user.getUsername());
            newUser.setPassword(encodedPassword);
            return userRepository.save(newUser);
        }
    }

    @Override
    public User findByUsername(String username) {
        return userRepository.findByUsername(username).
                orElseThrow( () -> new NoSuchElementException("No user found"));
    }
}