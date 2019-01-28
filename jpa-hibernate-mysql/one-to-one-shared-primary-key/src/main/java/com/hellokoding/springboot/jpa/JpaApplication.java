package com.hellokoding.springboot.jpa;

import com.hellokoding.springboot.jpa.book.Book;
import com.hellokoding.springboot.jpa.book.BookDetail;
import com.hellokoding.springboot.jpa.book.BookRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Arrays;

@SpringBootApplication
public class JpaApplication {
    public static void main(String[] args) {
        SpringApplication.run(JpaApplication.class, args);
    }

    @Bean
    public CommandLineRunner runner(BookRepository bookRepository) {
        return r -> {
            Book book1 = new Book();
            book1.setName("Hello Koding 1");

            BookDetail bookDetail1 = new BookDetail();
            bookDetail1.setNumberOfPages(100);
            bookDetail1.setBook(book1);
            book1.setBookDetail(bookDetail1);

            Book book2 = new Book();
            book2.setName("Hello Koding 2");

            BookDetail bookDetail2 = new BookDetail();
            bookDetail2.setNumberOfPages(100);
            bookDetail2.setBook(book2);
            book2.setBookDetail(bookDetail2);

            bookRepository.saveAll(Arrays.asList(book1, book2));
        };
    }
}
