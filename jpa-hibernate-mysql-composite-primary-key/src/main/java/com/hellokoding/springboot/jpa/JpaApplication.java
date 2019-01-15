package com.hellokoding.springboot.jpa;

import com.hellokoding.springboot.jpa.book.Book;
import com.hellokoding.springboot.jpa.book.BookRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;

@SpringBootApplication
@RequiredArgsConstructor
@Slf4j
class JpaApplication implements CommandLineRunner {
    private final BookRepository bookRepository;

    @Override
    public void run(String... args) {
        bookRepository.save(Book.builder()
                .name("Hello Koding")
                .publishedDate(new Date())
                .build());

        log.info("My books: " + bookRepository.findAll());
    }

    public static void main(String[] args) {
        SpringApplication.run(JpaApplication.class, args);
    }
}
