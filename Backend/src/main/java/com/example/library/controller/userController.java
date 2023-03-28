package com.example.library.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.library.User;
import com.example.library.service.UserService;

public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    //Get all users Controller
    @GetMapping()
    public List<User> getUsers() {
        return userService.getUsers();
    }

    //Add user Controller
    @PostMapping()
    public void registerNewUser(User user) {
        userService.addNewUser(user);
    }

    //Delete user Controller
    @DeleteMapping(path = "{userId}")
        public void deleteUser(@PathVariable Long userId){
            userService.deleteUser(userId);   
    }
    
}
