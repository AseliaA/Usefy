package com.example.usefy.service;

import com.example.usefy.model.User;
import com.example.usefy.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    private final PasswordEncoder encoder;
    private final UserRepository userRepository;

    public UserServiceImpl(PasswordEncoder encoder, UserRepository userRepository) {
        this.encoder = encoder;
        this.userRepository = userRepository;
    }

    @Override
    public void registerUser(User user) {
        String encodedPassword = encoder.encode(user.getPassword());
        user.setPassword(encodedPassword);
        userRepository.save(user);
    }

    @Override
    public User findUserByUsername(String username) {
        return userRepository.findByUsername(username).
                orElseThrow( () -> new RuntimeException("No user found"));
    }
}
