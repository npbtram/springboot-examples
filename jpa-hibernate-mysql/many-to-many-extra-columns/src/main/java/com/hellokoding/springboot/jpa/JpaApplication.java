package com.hellokoding.springboot.jpa;

import com.hellokoding.springboot.jpa.book.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import javax.transaction.Transactional;
import java.util.Date;

@SpringBootApplication
@Slf4j
public class JpaApplication {
    public static void main(String[] args) {
        SpringApplication.run(JpaApplication.class, args);
    }

    @Transactional
    @Bean
    public CommandLineRunner runner(BookRepository bookRepository, PublisherRepository publisherRepository) {
        return r -> {
            Publisher publisherA = new Publisher("Publisher A");
            publisherRepository.save(publisherA);
            log.info(publisherA.toString());

            Publisher publisherB = new Publisher("Publisher B");
            publisherRepository.save(publisherB);
            log.info(publisherB.toString());

            Book book1 = new Book("Book 1");
            book1.getBookPublishers().add(new BookPublisher(book1, publisherA, new Date()));
            book1.getBookPublishers().add(new BookPublisher(book1, publisherB, new Date()));
            bookRepository.save(book1);
            log.info(book1.toString());

            Book book2 = new Book("Book 2");
            book2.getBookPublishers().add(new BookPublisher(book2, publisherA, new Date()));
            bookRepository.save(book2);
            log.info(book2.toString());
        };
    }
}
