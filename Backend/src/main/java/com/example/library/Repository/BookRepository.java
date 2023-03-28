package com.example.library.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.library.Book;

public interface BookRepository extends JpaRepository<Book, Long> {
    
}
