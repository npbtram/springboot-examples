package com.hellokoding.springboot.jpa;

import com.hellokoding.springboot.jpa.book.Book;
import com.hellokoding.springboot.jpa.book.BookRepository;
import com.hellokoding.springboot.jpa.book.Publisher;
import com.hellokoding.springboot.jpa.book.PublisherRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.transaction.Transactional;
import java.util.HashSet;
import java.util.Set;

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
        Set<Publisher> publishers = new HashSet<>();
        Publisher publisherA = new Publisher("Publisher A");
        Publisher publisherB = new Publisher("Publisher B");
        publishers.add(publisherA);
        publishers.add(publisherB);

        Set<Book> books = new HashSet<>();
        Book book1 = new Book("Book 1", publishers);
        Book book2 = new Book("Book 2", publishers);
        books.add(book1);
        books.add(book2);

        publisherA.setBooks(books);
        publisherB.setBooks(books);

        bookRepository.saveAll(books);

        // fetch all books
        for(Book book : bookRepository.findAll()) {
            log.info(book.toString());
        }
    }
}
