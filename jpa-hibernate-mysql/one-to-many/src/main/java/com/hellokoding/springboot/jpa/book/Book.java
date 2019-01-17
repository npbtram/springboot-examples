package com.hellokoding.springboot.jpa.book;

import lombok.*;

import javax.persistence.*;

@Entity

@Data
@ToString(exclude = "bookCategory")
@EqualsAndHashCode(exclude = "bookCategory")
@RequiredArgsConstructor
@NoArgsConstructor
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private @NonNull String name;

    @ManyToOne
    @JoinColumn(name = "book_category_id")
    private @NonNull BookCategory bookCategory;
}
