package com.example.library.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.library.Book;

public interface BookRepository extends JpaRepository<Book, Long> {

    @Query("SELECT s FROM Book s WHERE s.title = ?1")
    Optional<Book> findBookByTitle(String title);
}
