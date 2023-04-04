package com.example.library.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.library.Role;
import com.example.library.User;
import com.example.library.Repository.UserRepository;
import com.example.library.Repository.RoleRepository;


@Service
public class UserService {
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    
    @Autowired
    public UserService(UserRepository userRepository, RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
    }

    //Get all users Service
    public List<User> getUsers() {
        return userRepository.findAll();
    }

    //Get user by id Service
    public User getUser(Long userId) {
        return userRepository.findById(userId).orElseThrow(() -> new IllegalStateException("User with id " + userId + " does not exist"));
    }
    
    //Add user Service
    public void addNewUser(User user) {
        Optional<User> userOptional = userRepository.findUserByEmail(user.getEmail());
        if (userOptional.isPresent()) {
            throw new IllegalStateException("User already exists");
        }
        userRepository.save(user);
    }

    //Add role Service
    public void addNewRole(Role role){
        Optional<Role> roleOptional = roleRepository.findByName(role.getName());
        if (roleOptional.isPresent()) {
            throw new IllegalStateException("Role already exists");
        }
        roleRepository.save(role);
    }

    //Add role to user Service
    public void addRoleToUser(Long userId, Long roleId) {
        User user = userRepository.findById(userId).orElseThrow(() -> new IllegalStateException("User with id " + userId + " does not exist"));
        Role role = roleRepository.findById(roleId).orElseThrow(() -> new IllegalStateException("Role with id " + roleId + " does not exist"));
        user.getRoles().add(role);
        userRepository.save(user);
    }


    //Delete user Service
    public void deleteUser(Long userId) {
        boolean exists = userRepository.existsById(userId);
        if (!exists) {
            throw new IllegalStateException("User with id " + userId + " does not exist");
        }
        userRepository.deleteById(userId);
    }
    
}
