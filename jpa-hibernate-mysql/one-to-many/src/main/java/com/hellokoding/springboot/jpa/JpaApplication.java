package com.hellokoding.springboot.jpa;

import com.hellokoding.springboot.jpa.book.Book;
import com.hellokoding.springboot.jpa.book.BookCategory;
import com.hellokoding.springboot.jpa.book.BookCategoryRepository;
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
    private BookCategoryRepository bookCategoryRepository;

    public static void main(String[] args) {
        SpringApplication.run(JpaApplication.class, args);
    }

    @Override
    @Transactional
    public void run(String... strings) throws Exception {
        // save a couple of categories
        Set<BookCategory> bookCategories = new HashSet<>();

        for (int i = 0; i < 2; i++) {
            BookCategory bookCategory = new BookCategory("Category " + i);
            Set<Book> books = new HashSet<>();
            for (int j = 0; j < 10; j++) {
                books.add(new Book(String.format("Book %d %d", i, j), bookCategory));
            }
            bookCategory.setBooks(books);

            bookCategories.add(bookCategory);
        }

        bookCategoryRepository.saveAll(bookCategories);

        // fetch all categories
        for (BookCategory bookCategory : bookCategoryRepository.findAll()) {
            log.info(bookCategory.toString());
        }
    }
}
