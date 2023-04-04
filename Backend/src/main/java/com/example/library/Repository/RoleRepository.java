package com.example.library.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.library.Role;

public interface RoleRepository extends JpaRepository<Role, Long>{
    
    @Query ("SELECT s FROM Role s WHERE s.name = ?1")
    Optional<Role> findByName(String name);
}
