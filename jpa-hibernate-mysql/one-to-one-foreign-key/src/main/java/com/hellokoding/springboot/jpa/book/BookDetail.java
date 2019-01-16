package com.hellokoding.springboot.jpa.book;

import lombok.*;

import javax.persistence.*;

@Entity

@Data
@ToString(exclude = "book")
@EqualsAndHashCode(exclude = "book")
@RequiredArgsConstructor
@NoArgsConstructor
public class BookDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @OneToOne(mappedBy = "bookDetail")
    private @NonNull Book book;

    private int numberOfPages;
}
