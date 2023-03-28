package com.example.library.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.library.User;
import com.example.library.service.UserService;

@RestController
@RequestMapping(path = "api/users")
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
    public void registerNewUser(@RequestBody User user) {
        userService.addNewUser(user);
    }

    //Delete user Controller
    @DeleteMapping(path = "{userId}")
        public void deleteUser(@PathVariable("userId") Long userId){
            userService.deleteUser(userId);   
    }
    
}
