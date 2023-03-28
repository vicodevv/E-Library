package com.example.library.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.library.User;
import com.example.library.Repository.UserRepository;

@Service
public class userService {
    private final UserRepository userRepository;
    
    @Autowired
    public userService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getUsers() {
        return userRepository.findAll();
    }

    //Add user
    public void addNewUser(User user) {
        Optional<User> userOptional = userRepository.findUserByEmail(user.getEmail());
        if (userOptional.isPresent()) {
            throw new IllegalStateException("User already exists");
        }
        userRepository.save(user);
    }

    //Delete user
    public void deleteUser(Long id) {
        boolean exists = userRepository.existsById(id);
        if (!exists) {
            throw new IllegalStateException("User with id " + id + " does not exist");
        }
        userRepository.deleteById(id);
    }
    
}
