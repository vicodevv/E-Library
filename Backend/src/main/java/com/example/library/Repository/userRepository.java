package com.example.library.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.library.User;

@Repository
public interface userRepository extends JpaRepository<User, Long> {
    
}
