package com.example.library.service;

import java.util.List;

import com.example.library.dto.Role;
import com.example.library.dto.User;

public interface UserService {
    User addNewUser(User user);
    Role addNewRole(Role role);
    void addRoleToUser(String userName, String roleName);
    List<User> getUsers();
    void deleteUser(Long userId);
    User getUser(String userName);
}
