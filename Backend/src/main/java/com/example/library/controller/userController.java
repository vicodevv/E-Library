package com.example.library.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.library.Role;
import com.example.library.User;
import com.example.library.service.UserService;

import lombok.Data;

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
    public ResponseEntity<List<User>> getUsers() {
        return ResponseEntity.ok().body(userService.getUsers());
    }

    //Add user Controller
    @PostMapping()
    public ResponseEntity<User>registerNewUser(@RequestBody User user) {
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("api/users").toUriString());
        return ResponseEntity.created(uri).body(userService.addNewUser(user));
    }

    //Add role Controller
    @PostMapping(path = "/role")
    public ResponseEntity<Role> addNewRole(@RequestBody Role role) {
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("api/users/role").toUriString());
        return ResponseEntity.created(uri).body(userService.addNewRole(role));
    }

    //Add role to user Controller
    @PostMapping(path = "/role/addroletouser")
    public ResponseEntity<?> addRoleToUser(@RequestBody RoleToUserForm form) {
        userService.addRoleToUser(form.getEmail(), form.getRoleName());
        return ResponseEntity.ok().build();
    }


    //Delete user Controller
    @DeleteMapping(path = "{userId}")
        public void deleteUser(@PathVariable("userId") Long userId){
            userService.deleteUser(userId);   
    }

    @Data
    class RoleToUserForm{
        private String email;
        private String roleName;
    }
    
}
