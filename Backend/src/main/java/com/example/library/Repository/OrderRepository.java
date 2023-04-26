package com.example.library.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.library.dto.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {
    Optional<Order> findByUserId(long userId);
	Optional<Order> findByBookId(long bookId);
}