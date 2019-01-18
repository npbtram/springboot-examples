package com.hellokoding.springboot.jpa;

import com.hellokoding.springboot.jpa.book.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.transaction.Transactional;
import java.util.Date;

@SpringBootApplication
@Slf4j
public class JpaApplication implements CommandLineRunner {
    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private PublisherRepository publisherRepository;

    public static void main(String[] args) {
        SpringApplication.run(JpaApplication.class, args);
    }

    @Override
    @Transactional
    public void run(String... strings) {
        // Create
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

        // Update child collection with orphanRemoval
        log.info(book1.getBookPublishers().size() + "");

        book1.getBookPublishers().removeIf(bookPublisher -> bookPublisher.getPublisher().equals(publisherB));
        bookRepository.save(book1);

        log.info(book1.getBookPublishers().size() + "");

        // Delete
        bookRepository.delete(book2);
    }
}
