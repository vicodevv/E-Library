package com.example.library.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.library.dto.Borrow;

public interface BorrowRepository extends JpaRepository<Borrow, Long> {
    Optional<Borrow> findByUserId(long userId);
	Optional<Borrow> findByBookId(long bookId);
}
