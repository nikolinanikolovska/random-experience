package com.example.randomexperience.service.impl;

import com.example.randomexperience.model.User;
import com.example.randomexperience.repository.UserRepository;
import com.example.randomexperience.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User register(String username, String password) {

        User user = new User(username, password);
        return userRepository.save(user);
    }

    @Override
    public User login(String username, String password) {

        return userRepository.findByUsername(username)
                .filter(u -> u.getPassword().equals(password))
                .orElseThrow(() -> new RuntimeException("Invalid credentials"));
    }
}