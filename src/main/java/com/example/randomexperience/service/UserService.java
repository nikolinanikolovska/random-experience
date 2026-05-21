package com.example.randomexperience.service;

import com.example.randomexperience.model.User;

public interface UserService {

    User register(String username, String password);

    User login(String username, String password);
}
