package com.example.library;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;

public class LibraryController {

    @GetMapping()
    public List<Library> getBooks() {
        return List.of(
            new Library("John", "Doe", "c@gmail.com", (long) 1234567890, "123 Main St")
        );
    }


    
}
