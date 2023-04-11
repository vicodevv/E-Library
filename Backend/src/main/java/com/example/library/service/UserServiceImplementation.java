package com.example.library.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.library.Role;
import com.example.library.User;
import com.example.library.Repository.UserRepository;

//import lombok.extern.slf4j.Slf4j;

import com.example.library.Repository.RoleRepository;

@Service
@Transactional
public class UserServiceImplementation implements UserService, UserDetailsService{
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;
    
    @Autowired
    public UserServiceImplementation(UserRepository userRepository, RoleRepository roleRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException{
        Optional<User> user = userRepository.findByUserName(userName);
        if (user == null) {
            throw new UsernameNotFoundException("User not found");
        } 
        Collection <SimpleGrantedAuthority> authorities = new ArrayList<>();
        user.get().getRoles().forEach(role -> {
            authorities.add(new SimpleGrantedAuthority(role.getName()));
        });
       return new org.springframework.security.core.userdetails.User(user.get().getUserName(), user.get().getPassword(), authorities);

    }

    //Get all users Service
    @Override
    public List<User> getUsers() {
        return userRepository.findAll();
    }
    
    //Add user Service
    @Override
    public User addNewUser(User user) {
        Optional<User> userOptional = userRepository.findByUserName(user.getUserName());
        if (userOptional.isPresent()) {
            throw new IllegalStateException("User already exists");
        }
        
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    //Add role Service
    @Override
    public Role addNewRole(Role role){
        Optional<Role> roleOptional = roleRepository.findByName(role.getName());
        if (roleOptional.isPresent()) {
            throw new IllegalStateException("Role already exists");
        }
        return roleRepository.save(role);
    }

    //Add role to user Service
    @Override
    public void addRoleToUser(String userName, String roleName) {
        User user = userRepository.findByUserName(userName).orElseThrow(() -> new IllegalStateException("User with id " + userName + " does not exist"));
        Role role = roleRepository.findByName(roleName).orElseThrow(() -> new IllegalStateException("Role with id " + roleName + " does not exist"));
        user.getRoles().add(role);
        userRepository.save(user);
    }


    //Delete user Service
    @Override
    public void deleteUser(Long userId) {
        boolean exists = userRepository.existsById(userId);
        if (!exists) {
            throw new IllegalStateException("User with id " + userId + " does not exist");
        }
        userRepository.deleteById(userId);
    }
}
