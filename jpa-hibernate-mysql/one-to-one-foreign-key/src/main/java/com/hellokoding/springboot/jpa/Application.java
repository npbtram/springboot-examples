package com.hellokoding.springboot.jpa;

import com.hellokoding.springboot.jpa.book.Address;
import com.hellokoding.springboot.jpa.book.Library;
import com.hellokoding.springboot.jpa.book.LibraryRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Arrays;

@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    public CommandLineRunner runner(LibraryRepository libraryRepository) {
        return r -> {
            Library library1 = new Library();
            library1.setName("Hello Koding 1");

            Library library2 = new Library();
            library2.setName("Hello Koding 2");

            Address address1 = new Address();
            address1.setStreet("Street 1");
            address1.setZipCode("1");
            address1.setLibrary(library1);

            Address address2 = new Address();
            address2.setStreet("Street 2");
            address2.setZipCode("2");
            address2.setLibrary(library1);

            library1.setAddress(address1);
            library2.setAddress(address2);

            libraryRepository.saveAll(Arrays.asList(library1, library2));
        };
    }
}
