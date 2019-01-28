package com.hellokoding.springboot.jpa;

import com.hellokoding.springboot.jpa.book.Book;
import com.hellokoding.springboot.jpa.book.BookCategory;
import com.hellokoding.springboot.jpa.book.BookCategoryRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.stream.Collectors;
import java.util.stream.Stream;

@SpringBootApplication
public class JpaApplication {
    public static void main(String[] args) {
        SpringApplication.run(JpaApplication.class, args);
    }

    @Bean
    public CommandLineRunner runner(BookCategoryRepository bookCategoryRepository) {
        return r -> {
            Book book1 = new Book();
            book1.setName("Hello Koding 1");
            Book book2 = new Book();
            book2.setName("Hello Koding 2");

            BookCategory bookCategory1 = new BookCategory();
            bookCategory1.setName("Category 1");
            bookCategory1.setBooks(Stream.of(book1, book2).collect(Collectors.toSet()));
            book1.setBookCategory(bookCategory1);
            book2.setBookCategory(bookCategory1);

            bookCategoryRepository.save(bookCategory1);
        };
    }
}
