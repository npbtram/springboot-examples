package com.hellokoding.springboot.jpa.book;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity

@Data
@EqualsAndHashCode(exclude = "bookPublishers")
public class Publisher {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String name;

    @OneToMany(mappedBy = "publisher", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnoreProperties("publisher")
    private Set<BookPublisher> bookPublishers = new HashSet<>();
}