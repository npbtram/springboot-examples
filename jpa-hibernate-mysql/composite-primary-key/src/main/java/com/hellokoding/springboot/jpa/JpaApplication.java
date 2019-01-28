package com.hellokoding.springboot.jpa;

import com.hellokoding.springboot.jpa.book.Book;
import com.hellokoding.springboot.jpa.book.BookRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Arrays;
import java.util.Date;

@Slf4j

@SpringBootApplication
class JpaApplication {
    public static void main(String[] args) {
        SpringApplication.run(JpaApplication.class, args);
    }

    @Bean
    public CommandLineRunner runner(BookRepository bookRepository) {
        return r -> {
            Book book1 = new Book();
            book1.setName("Hello Koding 1");
            book1.setPublishedDate(new Date());

            Book book2 = new Book();
            book2.setName("Hello Koding 2");
            book2.setPublishedDate(new Date());

            bookRepository.saveAll(Arrays.asList(book1, book2));

            log.info("My books: " + bookRepository.findAll());
        };
    }
}
