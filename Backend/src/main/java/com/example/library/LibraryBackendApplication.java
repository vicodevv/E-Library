package com.example.library;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.CrossOrigin;

@SpringBootApplication
public class LibraryBackendApplication {
 
	@CrossOrigin(origins = "http://localhost:4200")
	public static void main(String[] args) {
		SpringApplication.run(LibraryBackendApplication.class, args);
	}

}
