package com.hellokoding.springboot.jpa_hibernate_mysql.book;

import lombok.*;

import javax.persistence.*;

@Entity

@Data
@RequiredArgsConstructor
@NoArgsConstructor
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private @NonNull String name;

    @OneToOne(cascade = CascadeType.ALL, mappedBy = "book")
    private BookDetail bookDetail;
}
