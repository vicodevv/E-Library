package com.example.library.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;

import com.example.library.User;

public class userController {

    @GetMapping()
    public List<User> getBooks() {
        return List.of(
            new User("John", "Doe", "c@gmail.com", (long) 1234567890, "123 Main St")
        );
    }


    
}
