package com.example.library.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.library.Library;

@Repository
public interface userRepository extends JpaRepository<Library, Long> {
    
}
