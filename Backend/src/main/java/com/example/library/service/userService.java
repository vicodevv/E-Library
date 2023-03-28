package com.example.library.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.library.User;
import com.example.library.Repository.userRepository;

@Service
public class userService {
    private final userRepository libraryRepository;

    public userService(userRepository libraryRepository) {
        this.libraryRepository = libraryRepository;
    }

    public List<User> getBooks() {
        return libraryRepository.findAll();
    }

    
}
