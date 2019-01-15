package com.hellokoding.springboot.jpa;

import com.hellokoding.springboot.jpa.book.Book;
import com.hellokoding.springboot.jpa.book.BookDetail;
import com.hellokoding.springboot.jpa.book.BookRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
@Slf4j
public class JpaApplication implements CommandLineRunner {
    @Autowired
    private BookRepository bookRepository;

    public static void main(String[] args) {
        SpringApplication.run(JpaApplication.class, args);
    }

    @Override
    public void run(String... strings) throws Exception {
        // save a couple of books and book details
        List<Book> books = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Book book = new Book("Book " + (i+1));

            BookDetail bookDetail = new BookDetail(book);
            bookDetail.setNumberOfPages(100 + i);
            book.setBookDetail(bookDetail);

            books.add(book);
        }

        bookRepository.saveAll(books);

        // fetch all books
        bookRepository.findAll().forEach(b -> log.info(b.toString()));
    }
}
