package com.hellokoding.springboot.jpa;

import com.hellokoding.springboot.jpa.book.Book;
import com.hellokoding.springboot.jpa.book.BookDetail;
import com.hellokoding.springboot.jpa.book.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@RequiredArgsConstructor
@SpringBootApplication
public class JpaApplication implements CommandLineRunner {
    private final BookRepository bookRepository;

    public static void main(String[] args) {
        SpringApplication.run(JpaApplication.class, args);
    }

    @Override
    public void run(String... args) {
        createBookAndBookDetail("Hello Koding 1");
        createBookAndBookDetail("Hello Koding 2");
    }

    private void createBookAndBookDetail(String name) {
        Book book = new Book();
        book.setName(name);

        BookDetail bookDetail = new BookDetail();
        bookDetail.setNumberOfPages(100);
        bookDetail.setBook(book);
        book.setBookDetail(bookDetail);

        bookRepository.save(book);
    }
}
