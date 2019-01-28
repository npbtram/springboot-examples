package com.hellokoding.springboot.jpa.book;

import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data

@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    @OneToMany(mappedBy = "book", cascade = CascadeType.ALL)
    private Set<BookPublisher> bookPublishers = new HashSet<>();

    public Book(String name) {
        this.name = name;
    }
}
