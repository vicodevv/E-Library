package com.example.library.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.library.User;
import com.example.library.Repository.UserRepository;

@Service
public class userService {
    private final UserRepository userRepository;

    public userService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getUsers() {
        return userRepository.findAll();
    }

    
}
