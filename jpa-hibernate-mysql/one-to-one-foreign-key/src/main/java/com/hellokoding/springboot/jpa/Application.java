package com.hellokoding.springboot.jpa;

import com.hellokoding.springboot.jpa.book.Address;
import com.hellokoding.springboot.jpa.book.Library;
import com.hellokoding.springboot.jpa.book.LibraryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@RequiredArgsConstructor
@SpringBootApplication
public class Application implements CommandLineRunner {
    private final LibraryRepository libraryRepository;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        createLibraryAndAddress("Library 1", "Street 1", "1");
        createLibraryAndAddress("Library 2", "Street 2", "2");
    }

    private void createLibraryAndAddress(String libraryName, String street, String zipCode) {
        Library library = new Library();
        library.setName(libraryName);

        Address address = new Address();
        address.setStreet(street);
        address.setZipCode(zipCode);
        library.setAddress(address);

        libraryRepository.save(library);
    }
}
