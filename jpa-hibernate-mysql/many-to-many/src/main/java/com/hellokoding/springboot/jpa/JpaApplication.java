package com.hellokoding.springboot.jpa;

import com.hellokoding.springboot.jpa.book.Book;
import com.hellokoding.springboot.jpa.book.BookRepository;
import com.hellokoding.springboot.jpa.book.Publisher;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.HashSet;
import java.util.Set;

@SpringBootApplication
public class JpaApplication {
    public static void main(String[] args) {
        SpringApplication.run(JpaApplication.class, args);
    }

    @Bean
    public CommandLineRunner runner(BookRepository bookRepository) {
        return r -> {
            Set<Publisher> publishers = new HashSet<>();
            Publisher publisherA = new Publisher();
            publisherA.setName("Publisher A");
            publishers.add(publisherA);

            Publisher publisherB = new Publisher();
            publisherB.setName("Publisher B");
            publishers.add(publisherB);

            Set<Book> books = new HashSet<>();
            Book book1 = new Book();
            book1.setName("Book 1");
            book1.setPublishers(publishers);
            books.add(book1);

            Book book2 = new Book();
            book2.setName("Book 2");
            book2.setPublishers(publishers);
            books.add(book2);

            publisherA.setBooks(books);
            publisherB.setBooks(books);
            book1.setPublishers(publishers);
            book2.setPublishers(publishers);

            bookRepository.saveAll(books);
        };
    }
}
