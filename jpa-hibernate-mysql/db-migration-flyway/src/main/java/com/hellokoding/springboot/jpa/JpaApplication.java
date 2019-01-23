package com.hellokoding.springboot.jpa;

import com.hellokoding.springboot.jpa.book.BookRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@RequiredArgsConstructor
@Slf4j
class JpaApplication implements CommandLineRunner {
    private final BookRepository bookRepository;

    @Override
    public void run(String... args) {
        log.info("My books: " + bookRepository.findAll());
    }

    public static void main(String[] args) {
        SpringApplication.run(JpaApplication.class, args);
    }
}
